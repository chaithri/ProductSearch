package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class AmazonCategoryPage extends DriverClass{
	
	private static WebElement element = null;

	public AmazonCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement televisions() throws Exception{
		try {
			element = driver.findElement(By.linkText("Televisions"));
			Log.info("Televisions link found on Categories page");
		}
		catch(Exception e){
			Log.error("Televisions link not found on Categories page");
			throw e;
		}
		return element;
	}
	
	public static WebElement mobilePhones() throws Exception{
		try {
			element = driver.findElement(By.linkText("All Mobile Phones"));
			Log.info("Mobile Phones link found on Categories page");
		}
		catch(Exception e) {
			Log.error("Mobile Phones link not found on Categories page");
			throw e;
		}
		return element;
	}
	
	public static WebElement books() throws Exception{
		try {
			element = driver.findElement(By.linkText("All Books"));
			Log.info("Books link is found on Categories page");
		}
		catch(Exception e) {
			Log.error("Books link not found on Categories page");
			throw e;
		}
		return element;
	}
	
	public static WebElement cameras() throws Exception{
		try {
			element = driver.findElement(By.linkText("Cameras"));
			Log.info("Cameras link found on Categories page");
		}
		catch(Exception e){
			Log.error("Cameras link not found on Categories page");
			throw e;
		}
		return element;
	}
}
