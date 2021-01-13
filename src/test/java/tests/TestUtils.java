package tests;

import org.testng.annotations.Test;

import utilities.BrowserUtils;
import utilities.Driver;

public class TestUtils extends TestBase{
	
	@Test
	public void testScroll() {
		
		driver.get("https://www.duotech.io/");
		BrowserUtils.scroll(0, 2000);
		BrowserUtils.waitFor(5);
		BrowserUtils.takeScreenshot("Partial");
		BrowserUtils.takeFullScreenshot("Full");
		
	}

}
