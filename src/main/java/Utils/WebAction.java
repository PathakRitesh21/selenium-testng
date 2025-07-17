package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAction {
	private WebDriver driver;
	private WebDriverWait wait;

	public WebAction(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	}
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void sendText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		element.sendKeys(text);
	}
	
	public boolean isVisible(WebElement element) {
		return element.isDisplayed();
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select selection = new Select(element);
		selection.selectByIndex(index);
	}
	
	public void selectByText(WebElement element, String text) {
		Select selection = new Select(element);
		selection.selectByVisibleText(text);
	}
}
