package tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.config.Config;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase {
	
	
	
	
	protected WebDriver driver;
	protected Actions actions;
	protected JavascriptExecutor jsExecutor;
	
	protected static ExtentReports reporter;
	protected static ExtentSparkReporter htmlReporter;
	protected static ExtentTest logger;  // needs to be initialized in each test
	protected static int count;
	
	@BeforeSuite
	public void setUpReport() {
		reporter = new ExtentReports();
		String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";
		htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setReportName("WEB ORDERS AUTOMATION TESTS");
		
		reporter.attachReporter(htmlReporter);
		
		//set report configurations
		reporter.setSystemInfo("QA Automation Tester", "Barack Obama");
		reporter.setSystemInfo("Environment", "TEST/QA");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getProperty("browser"));
		
	}
	
	
	
	@BeforeMethod (alwaysRun = true)
	@Parameters ("browser")
	public void setupMethod(@Optional String browser) {
		
		driver = Driver.getDriver(browser);
		driver.manage().timeouts().
			implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor)driver;
		driver.get(ConfigReader.getProperty("url"));
		
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		logger = reporter.createTest("TEST "+ count + " created at: " + date );
		count++;
	}
	

	@AfterMethod (alwaysRun = true)
	public void teardownMethod(ITestResult testResult) throws IOException {
		
		if(testResult.getStatus()==ITestResult.SUCCESS) {
			logger.pass("TEST PASSED: "  + testResult.getName());
		}else if(testResult.getStatus() == ITestResult.SKIP) {
			logger.skip("TEST SKIPPED: " + testResult.getName());
		}else if (testResult.getStatus() == ITestResult.FAILURE) {
			logger.fail("TEST FAILED: " + testResult.getName());
			// Add exception message
			logger.fail(testResult.getThrowable());
			// Add screenshot
			
//			String path = BrowserUtils.getScreenshot("Failed");
//			
//			logger.addScreenCaptureFromPath(path);
			
		}
		
		
		
		
		Driver.quit();
	}
	
	
	@AfterSuite
	public void tearDownReport() {
		reporter.flush();
	}
	

}
