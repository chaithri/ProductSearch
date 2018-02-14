package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class AmazonSearchResultsPage extends DriverClass{
	
	private static WebElement element = null;
	 static List<WebElement> results=null;
	 static WebElement name=null;
	 static WebElement price=null;

	public AmazonSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement searchResults(int i) throws Exception{
		
		try {
				element = driver.findElement(By.id("mainResults"));
				results = element.findElements(By.cssSelector("li[id^='result']"));
				
			}
		catch(Exception e) {
			Log.error("Search Results not found");
			throw e;
		}
		
		return results.get(i);
		
	}
	
	public static WebElement prodName(int i) throws Exception{
		try {
			name=searchResults(i).findElement(By.tagName("h2"));
		}
		catch(Exception e) {
			Log.error("Product Name web element not found");
			throw e;
		}
		return name;
	}
	
	public static WebElement prodPrice(int i) throws Exception{
		try {
			//*[@id="result_0"]/div/div[5]/div[1]/a/span/span[1]
			price=searchResults(i).findElement(By.xpath(".//div/div[5]/div[1]/a/span/span[1]"));
		}
		catch(Exception e) {
			Log.error("Product price element not found");
			throw e;
		}
		return price;
	}
	

}
