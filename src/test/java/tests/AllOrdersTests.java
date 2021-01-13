package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageClasses.AllOrdersPage;
import pageClasses.LoginPage;

public class AllOrdersTests extends TestBase{
	
	
	
	@Test
	public void verifyCheckboxes() {
		LoginPage lp = new LoginPage();		
		
		lp.usernameField.sendKeys("Tester");
		lp.passwordField.sendKeys("test");
		lp.loginButton.click();
		
		assertEquals(driver.getTitle(), "Web Orders");
		
		
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
		LoginPage lp = new LoginPage();		
		
		lp.positiveLogin();
		
		assertEquals(driver.getTitle(), "Web Orders");
		
		
		AllOrdersPage op  = new AllOrdersPage();
		
		op.checkAllCheckBoxes();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(checkbox.isSelected());
		}
		
		op.uncheckAllCheckBoxes();
		
		for (WebElement checkbox : op.checkboxes) {
			assertTrue(!checkbox.isSelected());
		}
		
		
		
	}

}
