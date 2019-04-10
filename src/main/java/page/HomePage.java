package page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class HomePage {

	
public WebDriver driver;
	
	
	By logoutBtn = By.xpath("//a[@href='/user/sign-out/?ut_source=header']");
	By userOptionLink = By.id("userAcctTab_MainMenu");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	/**********************************************************************************************************************************
	 * Method Name - enterUserName()
	 * Description - Entering User Name on Login Page
	 * Creation Date - 13th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *********************************************************************************************************************************/
	
	
	
	public WebElement userOptions(){
		//return driver.findElement(userNameTxt);
		return driver.findElement(userOptionLink);
	}
	
	public WebElement Logout(){
		//return driver.findElement(userNameTxt);
		return driver.findElement(logoutBtn);
	}
	
		
	
	
}
