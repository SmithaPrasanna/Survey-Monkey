package page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage {

	
public WebDriver driver;
	
	
	By userNameTxt = By.xpath("//input[@id='username']");
	By passWordTxt = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**********************************************************************************************************************************
	 * Method Name - enterUserName()
	 * Description - Entering User Name on Login Page
	 * Creation Date - 13th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *********************************************************************************************************************************/
	public WebElement enterUserName(){
		//return driver.findElement(userNameTxt);
		return driver.findElement(userNameTxt);
	}
	
	/**********************************************************************************************************************************
	 * Method Name - enterPassword()
	 * Description - Entering Password on Login Page
	 * Creation Date - 13th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *********************************************************************************************************************************/
	public WebElement enterPassword(){
		//return driver.findElement(passWordTxt);
		return driver.findElement(passWordTxt);
	}
	
	/**********************************************************************************************************************************
	 * Method Name - clickLoginBtn()
	 * Description - Clicking on "Login" button on Login page
	 * Creation Date - 13th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *********************************************************************************************************************************/
	public WebElement clickLoginBtn(){
		//return driver.findElement(loginBtn);
		return driver.findElement(loginBtn);
	}
	
	
	
}
