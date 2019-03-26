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

public class CheckLandingPage extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
		public void initialize() throws IOException{
			driver = initializeDriver();
			log.info("Driver is initialized");
			driver.get(prop.getProperty("url"));
			log.info("----------------------Starting of the logs for class : " +CheckLandingPage.class.getName()+"----------------------" );
			log.info("Application : " + prop.getProperty("url") + " is opened" );
		}
		
		@Test
		public void ValidateTxtOnLandingPage() throws IOException
		{
			//Creating reference for Landing Page to access all methods
			LandingPage lp = new LandingPage(driver);
			log.info("Verifying the landing page is displayed");
			boolean getLoginTxt = lp.loginLinkDisplayed().isDisplayed();
			log.info("Landing page is displayed");
		}
		
		@AfterTest
		public void tearDown(){
			driver.close();
			log.info("Successfully closed the application");
			log.info("----------------------End of logs for class name : " +CheckLandingPage.class.getName()+"----------------------" );
			driver = null;
		}
}
