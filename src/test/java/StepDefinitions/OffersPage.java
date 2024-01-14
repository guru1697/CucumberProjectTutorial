package StepDefinitions;

import PageObjects.LandingPageObject;
import PageObjects.OffersPageObject;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OffersPage {

    WebDriver driver;
    public String offersPagePro;
    public String parentWindow;

    public LandingPageObject landingPageObject;

    public OffersPageObject offersPageObject;
    TestContextSetup testContextSetup;

    public OffersPage(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User search for same product {string} in offers page to verify if product exist")
    public void user_search_for_same_product_in_offers_page_to_verify_if_product_exist(String prodName) throws InterruptedException {
        landingPageObject = testContextSetup.pageObjectManager.getLandingPage(testContextSetup.driver);
        landingPageObject.toOffers();
        offersPageObject = testContextSetup.pageObjectManager.getOffersPage(testContextSetup.driver);
        offersPageObject.navigateToChildWindow();
        offersPageObject.searchProduct(prodName);
        offersPageObject.verificationOfProduct();
        offersPageObject.verificationInOffersPageForProduct();
        testContextSetup.driver.close();
        testContextSetup.driver.switchTo().window(offersPageObject.parentWindow);
//        testContextSetup.driver.quit();
//        Hooks hooks = new Hooks(testContextSetup);
//        hooks.AfterScenario();

    }

//    @Then("validate in both offers page product name matches with offers page product")
//    public void validateInBothOffersPageProductNameMatchesWithOffersPageProduct() {
//        Assert.assertEquals(testContextSetup.landingPagePro, offersPagePro);
//        System.out.println("Product name matches");
//    }
}
