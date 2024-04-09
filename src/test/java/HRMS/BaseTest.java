package HRMS;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver driver;
	ExtentReports extent;
	LoginPage login;
	ListModulePage ListModule;

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		// Set up ExtentReports
		String path = "D:\\Eclipse\\HRMS\\reports\\HRMS.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("HRMS Report");
		reporter.config().setDocumentTitle("Test Result");
		extent = new ExtentReports();
		// Attach the ExtentSparkReporter to the ExtentReports instance
		extent.attachReporter(reporter);
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		extent.flush();
	}

	@BeforeMethod
	public void startUp() throws InterruptedException {
		driver = new ChromeDriver();
		login = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.toPage(TestData.LoginPage);
		login.login(TestData.user, TestData.password);
		Thread.sleep(2000);
		ListModule = new ListModulePage(driver);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
