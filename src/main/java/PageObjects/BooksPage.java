package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	WebDriver driver;
	
	public BooksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id ="products-orderby")
	public WebElement productsOrderBy;
	
	@FindBy(id ="products-pagesize")
	public WebElement productsPageSize;
	
	@FindBy(id ="products-viewmode")
	public WebElement productsViewMode;
	
	@FindBy(xpath ="//a[contains(text(),'Over')]")
	public WebElement bookChoiceFilter;
	
	public WebElement addBookInCart(String bookName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + bookName + "')]/following::input[1]"));
	}
	
	public WebElement checkBookInCart(String bookName) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + bookName + "')]/following::input[1]"));
	}

}
