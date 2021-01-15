package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.AllOrdersPage;
import pageClasses.LoginPage;
import utilities.BrowserUtils;

public class AllOrdersTests extends TestBase{
	
	@BeforeMethod           // Superclass before methods are run before subclass before methods
	public void setUp() {
		
		LoginPage lp = new LoginPage();		
		
		lp.positiveLogin();
		
		assertEquals(driver.getTitle(), "Web Orders");
	}
	
	
	
	
	@Test
	public void verifyCheckboxes() {
		
		
		
		AllOrdersPage op  = new AllOrdersPage();
		
		op.checkAllButton.click();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(checkbox.isSelected());
		}
		
		op.uncheckAllButton.click();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(!checkbox.isSelected());
		}
		
		
		
	}
	
	
	
	@Test
	public void verifyCheckboxesusingPOMmethods() {
		
	
		
		AllOrdersPage op  = new AllOrdersPage();
		
		op.checkAllCheckBoxes();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(checkbox.isSelected());
		}
		
		op.uncheckAllCheckBoxes();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(!checkbox.isSelected());
		}
		
		throw new SkipException("skipped");
		
	}
	
	@Test
	public void verifyAllLinks() {
		
		
		
		logger.info("Obtaining all the links from the page");
		
		List<WebElement> links = new AllOrdersPage().allLinks;
		
		
		
		
		List<String> expectedLinkNames = Arrays.asList( "View all orders",
														"View all products",
														"Order",
														"Check All",
														"Uncheck All",
														"Logou"
														);
		
		logger.info("Extracting the link texts");
		List<String> actualLinkNames = BrowserUtils.getElementsText(links);
		
		logger.info("Sorting both lists");
		Collections.sort(actualLinkNames);
		Collections.sort(expectedLinkNames);
		logger.info("Comparing the lists");		
		
		assertEquals(actualLinkNames, expectedLinkNames);	
		
//		throw new SkipException("test skipped");  // to explicitly skip the test
		
			
		
	}
	
	 
	@AfterMethod           //Superclass after methods run after subclass after methods              
	public void tearDownSub() {
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Sub after");
	}

}
