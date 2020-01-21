package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public WebDriver driver;
	
    By stlogIn = By.xpath("//*[@id=\'homepage\']/header/div[1]/div/nav/ul/li[4]/a/span");
    
    
    public MainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	this.driver = driver;
	}


	public WebElement clickLogIn()
    {
    
		 return driver.findElement(stlogIn);
    }

}
