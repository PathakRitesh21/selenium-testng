package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Register')]")
	public WebElement registerLink;
	
	@FindBy(xpath ="//a[contains(text(),'Log in')]")
	public WebElement loginLink;
	
	@FindBy(xpath ="//a[contains(text(),'Books')]")
	public WebElement bookLink;
	
	@FindBy(xpath ="//span[contains(text(),'Shopping cart')]")
	public WebElement shoppingCartLink;
	
	@FindBy(xpath ="//a[contains(text(),'Log out')]")
	public WebElement logoutLink;

}
