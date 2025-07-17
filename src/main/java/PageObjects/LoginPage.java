package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WebAction;

public class LoginPage {
	WebDriver driver;
	private WebAction webAction;
	private HomePage homePage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "Email")
	public WebElement email;
	
	@FindBy(id = "Password")
	public WebElement password;
	
	@FindBy(xpath = "//input[@value = 'Log in']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]//preceding::li")
	public WebElement loginAccount;
	
	public void loginNewUser(String userEmail, String userPassword) {
		
		
		webAction = new WebAction(driver);
		homePage = new HomePage(driver);
		
		// Actions to be Performed
		webAction.click(homePage.loginLink);
		
		webAction.sendText(email, userEmail);
		webAction.sendText(password, userPassword);
		
		webAction.click(loginButton);

}}
