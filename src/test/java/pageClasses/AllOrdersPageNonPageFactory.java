package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AllOrdersPageNonPageFactory {
	
	
	//We can also use POM without using PageFactory class
	// In that case we would need to follow encapsulation principle of OOP to locate and return the webelements

	
	private WebElement checkAllButton = Driver.getDriver().findElement(By.linkText("Check All"));
	
	
	private WebElement uncheckAllButton = Driver.getDriver().findElement(By.linkText("Uncheck All"));


	public WebElement getCheckAllButton() {
		return checkAllButton;
	}


	public WebElement getUncheckAllButton() {
		return uncheckAllButton;
	}


	
	
	
	
	
	
	

}
