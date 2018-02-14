package amazonActions;

import pageObjects.AmazonCategoryPage;
import pageObjects.AmazonHome;
import pageObjects.AmazonTelevisionsPage;
import utility.Log;

public class ProductSelect_Action {
	
	public static void selectProduct() throws Exception{
	
		try {
			//Click Shop By category
			AmazonHome.shopByCategory().click();
			
			//Select Category - Televisions
			AmazonCategoryPage.televisions().click();
			
			//Select Brand - Sony
			AmazonTelevisionsPage.brand("Sony").click();
		}
		catch(Exception e) {
			Log.error("Error in ProductSelect_Action");
			throw e;
		}
	}

}
