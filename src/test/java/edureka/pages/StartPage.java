package edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

	private WebDriver startPageDriver;

	@FindBy(xpath = "/html/body/p[1]")
	@CacheLookup
	private WebElement firstParaText;

	@FindBy(linkText = "here")
	@CacheLookup
	private WebElement greetingLnk;

	public StartPage(WebDriver driver) {
		startPageDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageText() {
		return firstParaText.getText();
	}
  
  public String getPageTitle() {
		return startPageDriver.getTitle();
	}

	public WebDriver goToLink() {
		greetingLnk.click();
		return startPageDriver;
	}

}
