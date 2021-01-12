package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

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
			default:
				System.out.println("Wrong driver");
				break;
			}
			
			
			
			
		}
		
		
		
		return driver;
		
	}
	
	
	
	public static void quit() {
		
		
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
		
		


		
	}
	

}
