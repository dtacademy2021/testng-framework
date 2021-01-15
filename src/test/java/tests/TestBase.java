package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.config.Config;
import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase {
	
	
	
	
	protected WebDriver driver;
	protected Actions actions;
	protected JavascriptExecutor jsExecutor;
	
	protected static ExtentReports reporter;
	protected static ExtentSparkReporter htmlReporter;
	protected static ExtentTest logger;  // needs to be initialized in each test
	
	
	@BeforeSuite
	public void setUpReport() {
		reporter = new ExtentReports();
		String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";
		htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setDocumentTitle("WEB ORDERS AUTOMATION TESTS");
		
		reporter.attachReporter(htmlReporter);
		
		//set report configurations
		reporter.setSystemInfo("QA Automation Tester", "Barack Obama");
		reporter.setSystemInfo("Environment", "TEST/QA");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getProperty("browser"));
		
	}
	
	
	
	@BeforeMethod (alwaysRun = true)
	public void setupMethod() {
		
		driver = Driver.getDriver();
		driver.manage().timeouts().
			implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor)driver;
		driver.get(ConfigReader.getProperty("url"));
		
	}
	

	@AfterMethod (alwaysRun = true)
	public void teardownMethod() throws IOException {
		
		Driver.quit();
	}
	
	
	@AfterSuite
	public void tearDownReport() {
		reporter.flush();
	}
	

}
