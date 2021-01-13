package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClasses.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginTests extends TestBase{
	
	
	
		
	
	
	
	
	
	@Test  
	public void positiveLoginUsingPageObjectModel() {
		
		LoginPage lp = new LoginPage();
			
		lp.usernameField.sendKeys("Tester");
		lp.passwordField.sendKeys("test");
		lp.loginButton.click();
		
		String expectedURL = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		String actualURL = driver.getCurrentUrl();
		
		assertEquals(actualURL, expectedURL, "Urls didn't match");
	//	assertEquals(actualURL, expectedURL, "Urls didn't match"); optional argument with a failure message
	}
	
	
	
	@Test  
	public void negativeLogin1UsingPOM() {
		LoginPage lp = new LoginPage();		
		
		lp.usernameField.sendKeys("");
		lp.passwordField.sendKeys("");
		lp.loginButton.click();
		
		assertTrue(lp.errorMessage.isDisplayed());
		
		
		
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
	
	
		

}
