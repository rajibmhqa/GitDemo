package E2ETestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObject.MainPage;
import PageObject.loginPage;
import Utilities.basic;



public class HomePage extends basic {
	
	public static Logger log= LogManager.getLogger(basic.class.getName());
	

	
	@BeforeTest
	public void openUrl() throws IOException {
		driver=selectDriver();
		driver.get(prop.getProperty("URL"));
		log.info("URL Opened Successfully");
	}
	
	
	@Test
	public void loginClick() throws IOException, InterruptedException
	{
		
		
		MainPage mp = new MainPage(driver);
		mp.clickLogIn().click();
		
		loginPage lp = new loginPage(driver);
		lp.stemail().sendKeys("rajib@yahoo.com");
		lp.stpass().sendKeys("12345");
	//	lp.stloginClick().click();
		log.info("Clicked On Login Button Successfully");
		
		
		
	}
	
    // This code will run before executing any testcase
	
	


	
	@AfterTest
	
	public void CloseBrowser() throws IOException {
		driver.close();
		driver=null;
		log.info("Browser Closed Successfully");
	}
	
}
