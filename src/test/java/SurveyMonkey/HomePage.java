package SurveyMonkey;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LandingPage;
import page.LoginPage;
import resources.base;

public class HomePage extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 @BeforeTest
		public void initialize() throws IOException{
			driver = initializeDriver();
			log.info("Driver is Initialized");
		}
		
		@Test(dataProvider = "getData")
		public void HomePage(String username, String password) throws IOException
		{
			driver.get(prop.getProperty("url"));
			log.info("Navigated to : " + prop.getProperty("url"));
			//Creating reference for Landing Page to access all methods
			LandingPage lp = new LandingPage(driver);
			//Clicking on LOG IN link on Landing Page
			lp.clickLoginLink().click();
			log.info("Clicked on LOG IN Link");
			
			//Creating reference for Login Page to access all the methods
			LoginPage logPage = new LoginPage(driver);
			//Enter Login credentials and clicking in Login button
			logPage.enterUserName().sendKeys(username);
			log.info("Entered Username as : " + username);
			logPage.enterPassword().sendKeys(password);
			log.info("Entered Password as : " + password);
			logPage.clickLoginBtn().click();
			log.info("Clicked on LOG IN button");
		}
		
		@AfterTest
		public void tearDown(){
			driver.close();
			log.info("Successfully closed the application");
			driver = null;
		}
		
		@DataProvider
		public Object[][] getData(){
			Object[][] data = new Object[1][2];
			data[0][0] = "seleniumtraining";
			data[0][1] = "selenium1234";
			
			return data;
		}
	
}
