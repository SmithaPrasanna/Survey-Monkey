package SurveyMonkey;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.configuration.Config;

import page.LandPage;
import resources.base;

public class checkLandpage extends base{

	@BeforeTest
	public void openPage() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority=1)
	public void checkurl(){
		LandPage lp = new LandPage(driver);
		String actualurl = lp.getURL();
		Assert.assertEquals(actualurl, prop.getProperty("url"));
	}

	@Test(priority=2)
	public void checkText(){
		LandPage lp = new LandPage(driver);
		String ActualLPtext = lp.getLPText().getText();
		Assert.assertEquals(ActualLPtext, prop.getProperty("text"));
	}


	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}




}
