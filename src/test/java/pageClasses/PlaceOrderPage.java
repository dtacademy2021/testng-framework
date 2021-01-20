package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.Driver;

public class PlaceOrderPage extends PageClassBase{
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement customnerName;
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement address;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement state;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	
	public void chooseRandomCard() {
		int randCardNum = (int)(Math.random()*3);
        String str = String.valueOf(randCardNum);
        String chooseCard = "ctl00_MainContent_fmwOrder_cardList_" + str;
        Driver.getDriver().findElement(By.id(chooseCard)).click();
	}
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNo;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expiryDate;
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processButton;
	
	
	@FindBy (tagName = "strong")
	public WebElement successMessage;
	
	
	public String getSuccessMessage() {
		return successMessage.getText().trim();
	}
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement selectBox;
	
	
	
	public void selectProduct(String name) {
		new Select(selectBox).selectByVisibleText(name);
	}
	
	
	
 
}
