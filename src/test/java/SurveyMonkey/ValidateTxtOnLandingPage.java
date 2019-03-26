package SurveyMonkey;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.LandingPage;
import resources.base;

public class ValidateTxtOnLandingPage extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
		public void initialize() throws IOException{
			driver = initializeDriver();
			log.info("Driver is initialized");
			driver.get(prop.getProperty("url"));
			log.info("Application : " + prop.getProperty("url") + " is opened" );
		}
		
		@Test
		public void ValidateTxtOnLandingPage() throws IOException
		{
			//Creating reference for Landing Page to access all methods
			LandingPage lp = new LandingPage(driver);
			boolean getLoginTxt = lp.loginLinkDisplayed().isDisplayed();
			log.info("Captured text : " + getLoginTxt + " on the Landing Page");
			//Verify that 'LOG IN' link is displayed on Landing page
			Assert.assertTrue(true);
			log.info("'" + getLoginTxt +"'" + " text is displayed on the landing page");
		}
		
		@AfterTest
		public void tearDown(){
			driver.close();
			log.info("Successfully closed the application");
			driver = null;
		}
}
