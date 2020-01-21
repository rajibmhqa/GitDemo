package Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class basic {
	
	
	public static WebDriver driver;
	public Properties prop;
	public ExtentReports extent;
	public ExtentTest logger;

	
	public WebDriver selectDriver() throws IOException
	{
		
		prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\mdhus\\E2EProject\\src\\main\\java\\Utilities\\data.properties");
		
		prop.load(fis);
		String stBrowser=prop.getProperty("Browser");
		
		
		if (stBrowser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mdhus\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			
		}
		else if (stBrowser.equals("firefox"))
		{
			// code for firefox
		}
		else if (stBrowser=="IE")
		{
			// code for IE
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static String getScreenshots(ITestResult result) throws IOException 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String stSCPath = prop.getProperty("screenshotPath");
		//FileHandler.copy(src, new File(stFilepath));
		String path = "C://TestResult//ScreenShots//"+result+System.currentTimeMillis()+"screen.png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}
	
	
	@BeforeSuite
	public void setup()
	{
	    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
		
	    extent = new ExtentReports();
	    
	    extent.attachReporter(reporter);
	    
	}
	
	public void tearDown(ITestResult  result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=basic.getScreenshots(result);
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus()==ITestResult.SUCCESS) {
			String temp=basic.getScreenshots(result);
			
			logger.pass(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus()==ITestResult.STARTED) {
			String temp=basic.getScreenshots(result);
			
			logger.fatal(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush();
		driver.quit();
		
	}
	
	
}
	 
	
  
	
	


