package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
	//Loading the properties file
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\NavTech\\Desktop\\E2EProject\\E2EProject\\src\\main\\java\\resources\\config.properties");
			prop.load(fis);
			
			String browserName = prop.getProperty("browser");
			
			if (browserName.equalsIgnoreCase("chrome")) {
				//Opening Chrome Browser
				System.out.println("Chrome");
				System.setProperty("webdriver.chrome.driver", "C:\\ClassTraining\\Selenium\\Downloaded Files\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browserName.equalsIgnoreCase("ie")) {
				//Opening Internet Explorer
				System.out.println("Internet Explorer");
				System.setProperty("webdriver.ie.driver", "C:\\ClassTraining\\Selenium\\Downloaded Files\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else{
				//Opening Firefox
				System.out.println("Firefox");
				driver = new FirefoxDriver();
			}
			//Global synchronization time
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Maximize the browser
			driver.manage().window().maximize();
			
			return driver;
		}

//Capturing the screenshots where it is needed
public void getScreenShot(String result) throws IOException{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://ScreenShots//" + result + "Selenium.png"));
}

/*public void highLightElement(WebDriver driver, WebElement element)
{
JavascriptExecutor js=(JavascriptExecutor)driver; 
 
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
 
try 
{
Thread.sleep(500);
} 
catch (InterruptedException e) {
 
System.out.println(e.getMessage());
} 
 
js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
 
}*/
}
