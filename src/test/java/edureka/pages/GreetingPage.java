package edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreetingPage {

	private WebDriver greetingPageDriver;

	@FindBy(xpath = "/html/body/p")
	@CacheLookup
	private WebElement greetingText;

	public GreetingPage(WebDriver driver) {
		greetingPageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getGreetingText() {
		return greetingText.getText();
	}
  
  public String getPageTitle() {
		return greetingPageDriver.getTitle();
	}
}
