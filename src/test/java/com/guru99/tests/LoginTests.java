package com.guru99.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.ElementControl;
import freemarker.core.Comment;

public class LoginTests extends BaseTests {

	@Parameters({"username","userpassword"})
	@Test
	public void verifyLoginFunctionality(String username ,String password )
	{
		reportUtils.createATestCase("verify Login Functionality");

		reportUtils.addTestLogs(Status.INFO, "Performing Login");
		loginPage.loginToApplication(username, password);
		String expectedTitle = "Guru99 Bank Manager Home Page";
		String actualtitle = cmndriver.getTitle();

		reportUtils.addTestLogs(Status.INFO, "Comparing Expected and Actual title");
		assertEquals(expectedTitle, actualtitle);
	}
}
