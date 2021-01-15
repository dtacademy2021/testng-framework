package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestingGit extends TestBase{
@Test
	public void main() {
		driver.get("https://www.delta.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();

	}

}
