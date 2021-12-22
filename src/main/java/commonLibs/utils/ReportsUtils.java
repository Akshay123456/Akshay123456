package commonLibs.utils;

import java.security.PublicKey;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsUtils {

	//for html report
	ExtentHtmlReporter htmlReport;

	//Generate the reports
	ExtentReports extentReports;

	//Create Test cases
	ExtentTest extentTest;

	public ReportsUtils(String htmlReportFileName) {

		htmlReportFileName = htmlReportFileName.trim();

		htmlReport = new ExtentHtmlReporter(htmlReportFileName);

		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlReport);
	}

	public void createATestCase(String testCaseName)
	{
		extentTest = extentReports.createTest(testCaseName);
	}

	public void attachScreenshotToReport(String filename) throws Exception
	{
		extentTest.addScreenCaptureFromPath(filename);
	}

	public void addTestLogs(Status status, String comment)
	{
		extentTest.log(status, comment);
	}

	public void flushReport()
	{
		extentReports.flush();
	}
}
