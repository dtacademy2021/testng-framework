package tests;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageClasses.LoginPage;
import pageClasses.PlaceOrderPage;
import utilities.CSVReader;

public class PlaceOrderTests extends TestBase{
	
	
	
	@Test (dataProvider = "file")
	
	public void placeOrder( String name, 
			String address,String city,  String state, String zip, String cardNo) {
		
		new LoginPage().positiveLogin();
		
		PlaceOrderPage po = new PlaceOrderPage();
		
		po.orderLink.click();
		
		po.selectProduct("ScreenSaver");
		
		po.quantity.sendKeys(Keys.BACK_SPACE + "" + (new Random().nextInt(1000)+1));
		
		po.customnerName.sendKeys(name);
		
		po.address.sendKeys(address);
		
		po.city.sendKeys(city);
		
		po.state.sendKeys(state);
		
		po.zip.sendKeys(zip);
		
		po.chooseRandomCard();
		
		po.cardNo.sendKeys(cardNo);
		
		po.expiryDate.sendKeys("" + (new Random().nextInt(12)+1) + "/" +  (new Random().nextInt(20)+20));
		
		
		
		
	}
	
	/* Test data 
	 *  1. You can generate yourself
	 *  2. Faker class
	 *  3. External test data generators -> mockaroo 
	 *  4. It is provided by the management
	 */
	
	@DataProvider (name = "customers", parallel = true) // 
	public Object[][] getData(){
		
		return new Object[][]{
			
			{"Elnar Smaile","32053 Vermont Way","Louisville","Kentucky","40280","3575342479484615"},
			{"Madelina Stooders","2 Crescent Oaks Place","Toledo","Ohio","43605","5602221016252614"},
			{"Bev Fell","7 John Wall Plaza","Springfield","Missouri","65805","3569219554849284"},
			{"Carol Kensington","4 Hooker Road","El Paso","Texas","79928","4017951730641351"},
			{"Zerk Lapsley","9 Mesta Alley","El Paso","Texas","88584","5010123435700999"},
			{"Charin Tiptaft","6 Surrey Lane","Paterson","New Jersey","07505","30316995853318"},
			{"Lianne Aldwich","5 Chive Point","Salt Lake City","Utah","84110","5347027816396174"},
			{"Vivian Heugle","57 Holmberg Way","Birmingham","Alabama","35279","3539517249216885"},
			{"Dannie Wenzel","82 Vernon Park","Macon","Georgia","31205","5602254704999949"},
			{"Norene Carruth","4 Anniversary Place","Newark","New Jersey","07112","3539018742595370"}
			
			
		};
		
	}
	
	
	@DataProvider (name = "file", parallel = true) // 
	public Object[][] getDatafromCCV(){
		
		return CSVReader.readData("dataset.csv");
		
	}
	
	@Test
	public void placeOrderwithFaker() {
		
		new LoginPage().positiveLogin();
		
		PlaceOrderPage po = new PlaceOrderPage();
		
		po.orderLink.click();
		
		po.selectProduct("ScreenSaver");
		
		po.quantity.sendKeys(Keys.BACK_SPACE + "" + (new Random().nextInt(1000)+1));
		
		Faker fake = new Faker();
		
		po.customnerName.sendKeys(fake.name().fullName());
		
		po.address.sendKeys(fake.address().streetAddress());
		
		po.city.sendKeys(fake.address().city());
		
		po.state.sendKeys(fake.address().state());
		
		po.zip.sendKeys(fake.address().zipCode());
		
		po.chooseRandomCard();
		
		po.cardNo.sendKeys(fake.business().creditCardNumber());
		
		po.expiryDate.sendKeys(fake.business().creditCardExpiry());
		
		
		
		
	}
	
	
	
	
	
	
	

}
