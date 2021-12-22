package com.guru99.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportsUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTests {

	CommonDriver cmndriver;
	String url;
	WebDriver driver;
	LoginPage loginPage;
	String configFilName;
	String currentWorkingDirctory;
	Properties configproperty;
	ReportsUtils reportUtils;
	String reportFileName;
	String ScreenShotFileName;
	long executionTime = System.currentTimeMillis();


	ScreenshotUtils screenshot;

	@BeforeSuite
	public void PreSetup() throws Exception
	{
		String currentWorkingDirectory = System.getProperty("user.dir");
		configFilName = currentWorkingDirectory + "/config/config.properties";
		reportFileName = currentWorkingDirectory + "/reports/" + "guru99TestReport" + executionTime + ".html";
		configproperty = ConfigUtils.readproperties(configFilName);
		reportUtils = new ReportsUtils(reportFileName);
	}

	@BeforeClass
	public void setup () throws Exception{
		url = configproperty.getProperty("baseurl");
		String browsertype = configproperty.getProperty("browserType");
		{
			cmndriver = new CommonDriver(browsertype);
			driver = cmndriver.getDriver();
			loginPage = new LoginPage(driver);	
			screenshot = new ScreenshotUtils(driver);
			cmndriver.navigateToUrl(url);
		}
	}

	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception
	{
		String testcasename = result.getName();
		String currentWorkingDirectory = System.getProperty("user.dir");
		ScreenShotFileName = currentWorkingDirectory + "/screenshots/" + testcasename + executionTime + ".jpeg";
		if (result.getStatus() == ITestResult.FAILURE)
		{
			reportUtils.addTestLogs(Status.FAIL, "One or More steps are failed");
			screenshot.captureAndSaveScreenshot(ScreenShotFileName);
			reportUtils.attachScreenshotToReport(ScreenShotFileName);
		}

	}
	@AfterClass
	public void tearDown()
	{
		cmndriver.closeAllDrivers();
	}


	@AfterSuite
	public void closeReport()
	{
		reportUtils.flushReport();
	}

}
