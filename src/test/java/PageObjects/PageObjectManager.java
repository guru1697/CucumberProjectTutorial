package PageObjects;

import StepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;

    public LandingPageObject landingPageObject;
    public OffersPageObject offersPageObject;
    public Hooks hooks;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPageObject getLandingPage(WebDriver driver) {
        landingPageObject = new LandingPageObject(driver);
        return landingPageObject;
    }

    public OffersPageObject getOffersPage(WebDriver driver) {
        offersPageObject = new OffersPageObject(driver);
        return offersPageObject;
    }
}
