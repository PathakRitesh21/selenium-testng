package com.DemoWebShop.test;

import  org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Utils.WebAction;

public class TestRegisterNewUser extends BaseClass  {
	
	private HomePage homePage;
	private RegisterPage registerPage;
	private WebAction webAction;
	private LoginPage loginPage;


	
	@Test(enabled = false)
	public void registerNewUser() {
		
		homePage = new HomePage(getDriver());
		registerPage = new RegisterPage(getDriver());
		webAction = new WebAction(getDriver());
		loginPage = new LoginPage(getDriver());
		
		// Actions to be Performed
		
		webAction.click(homePage.registerLink);
		webAction.click(registerPage.maleChoice);
		webAction.sendText(registerPage.firstName, "John");
		webAction.sendText(registerPage.lastName, "Wick");
		webAction.sendText(registerPage.email, "johnwick@killer.com");
		webAction.sendText(registerPage.password, "JohnWick@007");
		webAction.sendText(registerPage.confirmPassword, "JohnWick@007");
		webAction.click(registerPage.registerButton);
		
		// Verification
		Assert.assertTrue(webAction.isVisible(registerPage.registerationSuccesssMessage));
		
	}
	
	@Test
	public void loginNewUser() {
		
		homePage = new HomePage(getDriver());
		registerPage = new RegisterPage(getDriver());
		webAction = new WebAction(getDriver());
		loginPage = new LoginPage(getDriver());
		
		// Actions to be Performed
		reportUtils.createATestCase("loginNewUser");
		reportUtils.addTestLog(Status.INFO, "loginNewUser");
		webAction.click(homePage.loginLink);
		
		webAction.sendText(loginPage.email, "johnwick@killer.com");
		webAction.sendText(loginPage.password, "JohnWick@007");
		
		webAction.click(loginPage.loginButton);
		
		// Verification
		reportUtils.addTestLog(Status.INFO, "Verification");
		Assert.assertEquals(loginPage.loginAccount.getText(),"johnSnow@killer.com");
		
		
		
	}
	
	
	
	

}
