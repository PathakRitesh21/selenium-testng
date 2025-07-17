package com.DemoWebShop.test;

import  org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import PageObjects.BooksPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.ShoppingCartPage;
import Utils.WebAction;

public class TestAddBookInCart extends BaseClass  {
	
	private HomePage homePage;
	private WebAction webAction;
	private LoginPage loginPage;
	private BooksPage booksPage;
	private ShoppingCartPage shoppingCartPage;
	


	@Test
	@Parameters ({"userEmail", "userPassword"})
	public void addBookInCart(String userEmail,String userPassword) {
		
		homePage = new HomePage(getDriver());
		webAction = new WebAction(getDriver());
		loginPage = new LoginPage(getDriver());
		booksPage = new BooksPage(getDriver());
		shoppingCartPage = new ShoppingCartPage(getDriver());
		
		// Actions to be Performed
		reportUtils.createATestCase("addBookInCart");
		reportUtils.addTestLog(Status.INFO, "addBookInCart");
		loginPage.loginNewUser(userEmail, userPassword);
		
		webAction.click(homePage.bookLink);
		webAction.selectByText(booksPage.productsOrderBy, "Name: A to Z");
		webAction.click(booksPage.addBookInCart("Computing and Internet"));
		
		
		// Verification
		reportUtils.addTestLog(Status.INFO, "Verification");
		Assert.assertTrue(webAction.isVisible(shoppingCartPage.addProductMessage));
		
		
		
		//Remove from ShoppingCart
		webAction.click(homePage.shoppingCartLink);
		webAction.isVisible(booksPage.checkBookInCart("Computing and Internet"));
		webAction.click(shoppingCartPage.removeFromCart);
		webAction.click(shoppingCartPage.updateCart);
		
		// Verification
		Assert.assertTrue(shoppingCartPage.emptyCartSummary.getText().contains("Your Shopping Cart is empty!"));
		
		
		webAction.click(homePage.logoutLink);
		
		
		
		
		
	}
	
	
	
	

}
