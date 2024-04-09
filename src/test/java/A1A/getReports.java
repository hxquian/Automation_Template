package A1A;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class getReports {

	
	public static ExtentReports getReport() {
		String path = System.getProperty("user.dir") + "//reports/HRMS.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("HRMS Automation Report");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "An");
		return extent;
	}
}
