package edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edureka.constants.IConstants;
import edureka.pages.StartPage;
import edureka.pages.GreetingPage;

public class AppTest {

    public WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {

        System.setProperty("webdriver.gecko.driver", IConstants.GECKODRIVERPATH);
        FirefoxOptions options = new FirefoxOptions();
		    options.setHeadless(true);
        driver = new FirefoxDriver(options);

        Reporter.log("Browser Opened", true); // setting to true will print in console too

        driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITWAITSTND, TimeUnit.SECONDS);
        driver.get("http://localhost:3333");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test(description = "verify start page")
    public void startPageTest() {
        StartPage startPage = new StartPage(driver);
        String pageText = startPage.getPageText();
        String pageTitle = startPage.getPageTitle();
        Assert.assertEquals(pageText.contains("superServe"), true);
        Assert.assertEquals(pageTitle.contains("superServe"), true);
    }

    @Test(description = "verify greeting")
    public void greetingPageTest() {
        StartPage startPage = new StartPage(driver);
        GreetingPage greetingPage = new GreetingPage(startPage.goToLink());
        String greetingText = greetingPage.getGreetingText();
        String pageTitle = greetingPage.getPageTitle();
        Assert.assertEquals(greetingText.contains("Hello, World!"), true);
        Assert.assertEquals(pageTitle.contains("superServe"), true);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
