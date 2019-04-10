package SurveyMonkey;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.asserts.Assertion;

import page.HomePage;
import page.LandPage;
import page.LandingPage;
import page.LoginPage;
import resources.ExcelUtils;
import resources.base;

public class LoginTest extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@Test(dataProvider = "dp")
	public void AppLogin(String user, String password) {

		// Enter credentials on login page
		LoginPage lgp = new LoginPage(driver);
		lgp.enterUserName().clear();
		lgp.enterUserName().sendKeys(user);

		lgp.enterPassword().sendKeys(password);
		lgp.clickLoginBtn().click();

		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.surveymonkey.com/dashboard/")) {
			System.out.println("found login button");
			// Logout
			HomePage hp = new HomePage(driver);
			hp.userOptions().click();
			hp.Logout().click();
			

		} else {
			System.out.println("no logout");
		}

	}

	@DataProvider
	public Object[][] dp() throws Exception {
		System.out.println("entered dp in test");
//		ExcelUtils excel = new ExcelUtils();
		Object data[][] = ExcelUtils.readExcel("Sheet1");
		System.out.println(data);
	
		return data;
		}

	@BeforeTest
	public void beforeTest() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// Navigate to login page
		LandingPage lp = new LandingPage(driver);
		lp.clickLoginLink().click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Successfully closed the application");
		driver = null;
	}

}
