package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath ="//p[contains(text(),'The product has been added to your ')]")
	public WebElement addProductMessage;
	
	@FindBy(xpath ="//input[@name='removefromcart']")
	public WebElement removeFromCart;
	
	@FindBy(xpath ="//input[@name='updatecart']")
	public WebElement updateCart;
	
	@FindBy(xpath ="//div[@class='order-summary-content']")
	public WebElement emptyCartSummary;

}
