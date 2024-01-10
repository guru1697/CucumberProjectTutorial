package Utils;

import PageObjects.OffersPageObject;
import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public String parentWindow;
    public String landingPagePro;
    public TestBase testBase;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        driver = testBase.InvokeDriver();
        pageObjectManager = new PageObjectManager(driver);
    }
}
