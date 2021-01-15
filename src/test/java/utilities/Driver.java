package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {   
	
	private static WebDriver driver;
	
	private Driver() {}
	
	
	
	public static WebDriver getDriver() {
		
		if(driver == null) {
			
			String browser = ConfigReader.getProperty("browser").toLowerCase();
			
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "headlesschrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); // option that must be added only for Windows systems
				driver = new ChromeDriver(options);
				break;	
			case "headlessfirefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
	            foptions.addArguments("--headless");
	          	driver = new FirefoxDriver(foptions);
				break;	
			case "phantomjs":
				WebDriverManager.phantomjs().setup();
				driver 	= new PhantomJSDriver();
				break;		
			case "htmlunit":
				driver = new HtmlUnitDriver(true); //true --> enables JavaScript
				break;		
				
			default:
				System.out.println("Wrong driver");
				break;
			}
			
			
			
			
		}
		
		
		
		return driver;
		
	}
	
	
	
	public static void quit() {
		
		
		if(driver != null) {
			driver.quit();  // quit() does not set driver instance to null;
			driver = null; // makes sure that driver instance is set to null so that next test method initializes its own driver
		}
		
		
	}
	

}
