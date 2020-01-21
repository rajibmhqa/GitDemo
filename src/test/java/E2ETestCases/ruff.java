package E2ETestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.basic;

public class ruff extends basic{
	
	public static Logger log= LogManager.getLogger(basic.class.getName());
	
	@BeforeTest
	public void openUrl() throws IOException {
		driver=selectDriver();
		driver.get(prop.getProperty("URL"));
		log.info("URL Opened Successfully");
	}
	
	@Test
	public void ShowName() {
		
		System.out.println("Rajib");
	}
	
	
@AfterTest
	
	public void CloseBrowser() throws IOException {
		driver.close();
		driver=null;
		log.info("Browser Closed Successfully");
	}

}
