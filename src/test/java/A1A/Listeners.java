package A1A;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import HRMS.BaseTest;

public class Listeners implements ITestListener {

	WebDriver driver;

	ExtentTest test;
	ExtentReports extent = getReports.getReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

	public String getScreenshot(String testCaseName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + testCaseName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination;
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = BaseTest.driver;

		// Capture screenshot
		String screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);

		// Add the screenshot to the extent report
		test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");

		// Log error details
		test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
