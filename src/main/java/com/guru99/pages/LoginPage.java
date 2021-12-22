package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage extends BasePage {

	@CacheLookup
	@FindBy (name = "uid")
	private WebElement userId;

	@CacheLookup
	@FindBy (name = "password")
	private WebElement userpassword;

	@CacheLookup
	@FindBy (name = "btnLogin")
	private WebElement loginButton;

	@CacheLookup
	@FindBy (name = "btnReset")
	private WebElement Reset;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication (String username,String password)
	{
		elementControl.setText(userId, username);
		elementControl.setText(userpassword, password);
		elementControl.clickElement(loginButton);
	}

}
