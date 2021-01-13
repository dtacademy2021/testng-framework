package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.config.Config;
import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase {
	
	
	
	
	protected WebDriver driver;
	protected Actions actions;
	protected JavascriptExecutor jsExecutor;
	
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
	

}
