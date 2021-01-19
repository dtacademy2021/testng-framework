package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AllProductsPage  extends PageClassBase{
	
	
	
	@FindBy (tagName = "h2")
	public WebElement text;
	
	

}
