package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazonActions.ProductSelect_Action;
import amazonActions.SearchResults_Action;
import pageObjects.DriverClass;
import utility.AccessExcel;
import utility.Constant;
import utility.Log;

public class TC_001 {
	public WebDriver driver=null;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void initialize(String browser)throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		
		Log.startTestCase("TC_001");
		
		AccessExcel.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
			
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		
		driver.get(Constant.amazon);
		
		new DriverClass(driver);
		
	}
	
	@Test
	public void execute()throws Exception{
		try {
			
			ProductSelect_Action.selectProduct();
			SearchResults_Action.execute();
			
		}
		catch(Exception e) {
			Log.error("Test Case 1 -- Failed");
			throw e;
		}
	}
	
	@AfterMethod
	public void close() {
		
		Log.endTestCase("TC_001");
		driver.close();
	}
	
}
