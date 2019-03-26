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

public class VerifyUrl extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
		public void initialize() throws IOException{
			driver = initializeDriver();
			log.info("Driver is initialized");
			driver.get(prop.getProperty("url"));
			log.info("----------------------Starting of the logs for class : " +VerifyUrl.class.getName()+"----------------------" );
			log.info("Application : " + prop.getProperty("url") + " is opened" );
		}
		
		@Test
		public void ValidateTxtOnLandingPage() throws IOException
		{
			//Creating reference for Landing Page to access all methods
			LandingPage lp = new LandingPage(driver);
			log.info("Verifying the URL of the application");
			String getUrl = lp.captureUrl();
			Assert.assertEquals("URL of the application is matching", prop.getProperty("url"), getUrl);
			log.info("Opened correct application");
		}
		
		@AfterTest
		public void tearDown(){
			driver.close();
			log.info("Successfully closed the application");
			log.info("----------------------End of logs for class name : " +VerifyUrl.class.getName()+"----------------------" );
			driver = null;
		}
}
