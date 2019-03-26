package SurveyMonkey;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;



public class listeners implements ITestListener {
 base b = new base();
	public void onTestStart(ITestResult result) {
				
	}

	public void onTestSuccess(ITestResult result) {
		try {
			b.getScreenShot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void onTestFailure(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
				
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
				
	}

	public void onStart(ITestContext context) {
				
	}

	public void onFinish(ITestContext context) {
				
	}

}
