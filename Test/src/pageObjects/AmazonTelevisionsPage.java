package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class AmazonTelevisionsPage extends DriverClass{
	
	private static WebElement brand = null;
	private static WebElement element = null;

	public AmazonTelevisionsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public static WebElement brand(String s)throws Exception{
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			//brand = driver.findElement(By.xpath("//div[@id='leftNav_438292']/div[2]/ul"));
			
			brand = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id^='leftNav_']")));
			element = brand.findElement(By.linkText(s));
			
			
		}
		catch(Exception e) {
			Log.error("Featured Brands not found");
			throw e;
		}
		return element;
	}
	

}
