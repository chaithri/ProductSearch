package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class AmazonHome extends DriverClass {
	
	private static WebElement element = null;

	public AmazonHome(WebDriver driver) {
		
		super(driver);
		
	}
	
	public static WebElement shopByCategory() throws Exception{
		
		try {
			
			element = driver.findElement(By.id("nav-link-shopall"));
			Log.info("Shop By Category link is found on the home page");
		}
		catch (Exception e) {
			Log.error("Shop By Category Link not found on the home page");
			throw(e);
		}
		return element;
		
	}
	
	

}
