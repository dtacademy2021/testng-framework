package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	
	WebDriver driver;
	
	
	@BeforeGroups (groups = {"ui"})
	public void setupGroup() {
		System.out.println("Setting up UI tests");
	}
	
	
	@AfterGroups (groups = {"ui"})
	public void tearDownGroup() {
		System.out.println("Tearing down UI tests");
	}
	
	
	@BeforeClass (alwaysRun = true)
	public void setupClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
	}
	
	
	@BeforeMethod (alwaysRun = true)
	public void setupMethod() {
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}
	
	@AfterClass (alwaysRun = true)
	public void teardownClass() {
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void teardownMethod() throws IOException {
		// Based on the test result (pass, fail, skipped) you can put logic to take a screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		FileUtils.copyFile(screenshot, new File("screenshots/screenshot"+ System.currentTimeMillis() +".png"));
		
		driver.quit();
	}
	
	
	@Test  
	public void positiveLogin() {
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		String actualURL = driver.getCurrentUrl();
		
		assertEquals(actualURL, expectedURL, "Urls didn't match");
	//	assertEquals(actualURL, expectedURL, "Urls didn't match"); optional argument with a failure message
	}
	
	
	@Test  
	public void negativeLogin1() {
				
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		WebElement errorMessage =  driver.findElement(By.id("ctl00_MainContent_status"));
		
		assertTrue(errorMessage.isDisplayed());
		
		
		
	}
	
	@Test 
	public void negativeLogin2() {
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("incorrectPassword");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		WebElement errorMessage =  driver.findElement(By.id("ctl00_MainContent_status"));
		
		assertTrue(errorMessage.isDisplayed());
		
	}
	
	@Test  
	public void negativeLogin3() {
		
		
			
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("IncorrectUsername");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		WebElement errorMessage =  driver.findElement(By.id("ctl00_MainContent_status"));
		
		assertTrue(errorMessage.isDisplayed());
		
	}
		

}
