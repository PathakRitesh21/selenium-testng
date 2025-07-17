package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	public WebElement maleChoice;
	
	@FindBy(id = "gender-female")
	public WebElement femaleChoice;
	
	@FindBy(id = "FirstName")
	public WebElement firstName;
	
	@FindBy(id = "LastName")
	public WebElement lastName;
	
	@FindBy(id = "Email")
	public WebElement email;
	
	@FindBy(id = "Password")
	public WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmPassword;
	
	@FindBy(id = "register-button")
	public WebElement registerButton;
	
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	public WebElement registerationSuccesssMessage;

}
