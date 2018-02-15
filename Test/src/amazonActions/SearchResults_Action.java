package amazonActions;

import pageObjects.AmazonSearchResultsPage;
import utility.AccessExcel;
import utility.Log;

public class SearchResults_Action {
	

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
			
				s = AmazonSearchResultsPage.prodPrice(i).getAttribute("innerText");
				System.out.println(s);
		}
		catch(Exception e) {
			Log.error("Error retrieving product price");
			throw e;
		}
		return s;
	}
	
	public static void execute() throws Exception{
		try {
			for(int i=0;i<20;i++) {
				AccessExcel.createRow(i);
				AccessExcel.setCellData(getProductName(i),0);
				Log.info("Prod name entered to excel sheet"+i);
				AccessExcel.setCellData(getProductPrice(i),1);
				Log.info("Prod price entered to excel sheet"+i);
			}
				
		}
		catch(Exception e) {
			throw e;
		}
	}
}
