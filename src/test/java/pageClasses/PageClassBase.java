package pageClasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public abstract class PageClassBase {
	
	public PageClassBase() {
		PageFactory.initElements(Driver.getDriver(), this);  
	}
	
	
	
	@FindBy (tagName = "a")
	public List<WebElement> allLinks;
	
	@FindBy (xpath = "//a[.='View all orders']")
	public WebElement viewAllOrdersLink;
	
	@FindBy (xpath = "//a[.='View all products']")
	public WebElement viewAllProductsLink;
	
	@FindBy (xpath = "//a[.='Order']")
	public WebElement orderLink;
	
	@FindBy (xpath = "//a[.='Logout']")
	public WebElement logOutLink;
	
	

}
