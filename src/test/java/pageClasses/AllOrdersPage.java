package pageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AllOrdersPage {
	
	public AllOrdersPage() {
		PageFactory.initElements(Driver.getDriver(), this);  
	}
	
	

	@FindBy (linkText = "Check All")
	public WebElement checkAllButton;
	
	@FindBy (xpath = "//a[.='Uncheck All']")
	public WebElement uncheckAllButton;
	
	
	@FindBy (xpath = "//input[@type='checkbox']")
	public List<WebElement> checkboxes ;
	
	
	public void checkAllCheckBoxes() {
		checkAllButton.click();
	}
	
	public void uncheckAllCheckBoxes() {
		uncheckAllButton.click();
	}
	
	
	

}
