package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandPage {
	public WebDriver driver; 
	
	//x=paths required for this page
	By Landingpagetxt =  By.xpath("//h1[@class='national-med white medium hero-text-1']");
	
	public LandPage(WebDriver driver){
		this.driver = driver;
	}


	public String getURL() {
		return driver.getCurrentUrl();
		// TODO Auto-generated method stub

	}
	
	public WebElement getLPText(){
		return driver.findElement(Landingpagetxt);
	}

}
