package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
public WebDriver driver;
	
	By loginLnk = By.xpath("//a[@class='log-in static-buttons']");
	By txtOnLandingPg = By.xpath("//h1[@class='national-med white medium hero-text-1']");
	By xyzLnk = By.xpath("//a[@class='log-in static-buttons']");

	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	/*****************************************************************************************
	 * Method Name - clickLoginLink()
	 * Description - To click on "LOG IN" link on Landing Page
	 * Creation Date - 13th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 * Modified by - 
	 *****************************************************************************************/
	public WebElement clickLoginLink(){
		return driver.findElement(loginLnk);
	}
	
	/*****************************************************************************************
	 * Method Name - getAnswerText()
	 * Description - To capture the text on Landing page
	 * Creation Date - 14th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *****************************************************************************************/
	public WebElement getAnswerText(){
		return driver.findElement(txtOnLandingPg);
	}
	
	/*****************************************************************************************
	 * Method Name - loginLinkDisplayed()
	 * Description - To verify that Login link is displayed
	 * Creation Date - 14th Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *****************************************************************************************/
	public WebElement loginLinkDisplayed(){
		return driver.findElement(loginLnk);
	}
	
	/*****************************************************************************************
	 * Method Name - captureUrl()
	 * Description - To capture the URL of the application
	 * Creation Date - 23rd Dec 2018
	 * Author - Naresh Kumar Guntipalli
	 *****************************************************************************************/
	public String captureUrl(){
		return driver.getCurrentUrl();
	}
	
	/*****************************************************************************************
	 * Method Name - XYZLinkDisplayed()
	 * Description - To verify that XYZ link is displayed
	 * Creation Date - 16th Mar 2019
	 * Author - Kumar
	 *****************************************************************************************/
	public WebElement XYZLinkDisplayed(){
		return driver.findElement(loginLnk);
	}
	
}
