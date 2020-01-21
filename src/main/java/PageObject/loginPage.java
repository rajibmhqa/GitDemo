package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {
	
	public WebDriver driver;
	
	
	
	
	By myemail = By.xpath("//*[@id='user_email']");
	By mypassword = By.xpath("//*[@id=\'user_password\']");
	By clicklogin = By.xpath("//*[@id=\'new_user\']/div[3]/input");

	public loginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public WebElement stemail() {
		return driver.findElement(myemail);
		
	}
	
	public WebElement stpass() {
		return driver.findElement(mypassword);
	}
	
	public WebElement stloginClick() {
		return driver.findElement(clicklogin);
	}
	
	
}

