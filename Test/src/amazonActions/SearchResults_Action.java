package amazonActions;

import org.openqa.selenium.WebDriver;

import pageObjects.AmazonSearchResultsPage;
import pageObjects.DriverClass;
import utility.AccessExcel;
import utility.Log;

public class SearchResults_Action extends DriverClass{
	
	public SearchResults_Action(WebDriver driver) {
		super(driver);
		
	}

	private static String s;

	public static String getProductName(int i) throws Exception{
		try {
			
				s= AmazonSearchResultsPage.prodName(i).getText();
		}
		catch(Exception e) {
			Log.error("Error retrieving product names");
			throw e;
		}
		return s;
	}
	
	public static String getProductPrice(int i) throws Exception{
		try {
			
				s = AmazonSearchResultsPage.prodPrice(i).getText();
		}
		catch(Exception e) {
			Log.error("Error retrieving product names");
			throw e;
		}
		return s;
	}
	
	public static void execute() throws Exception{
		try {
			for(int i=0;i<5;i++) {
				AccessExcel.createRow(i);
				AccessExcel.setCellData(getProductName(i),0);
				AccessExcel.setCellData(getProductPrice(i),1);
			}
				
		}
		catch(Exception e) {
			throw e;
		}
	}
}
