package StepDefinitions;

import PageObjects.LandingPageObject;
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

public class landingPage {

    //    WebDriver driver;
//    public String landingPagePro;
    TestContextSetup testContextSetup;
    LandingPageObject landingPageObject;


    public landingPage(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        landingPageObject = testContextSetup.pageObjectManager.getLandingPage(testContextSetup.driver);
        landingPageObject.getPageTitle();
    }

    @When("User searched with the short name {string} and extracted the actual name")
    public void user_searched_with_the_short_name_and_extracted_the_actual_name(String product) throws InterruptedException {
        landingPageObject = testContextSetup.pageObjectManager.getLandingPage(testContextSetup.driver);
        landingPageObject = new LandingPageObject(testContextSetup.driver);
        landingPageObject.searchItem(product);
        landingPageObject.getProductText();
        landingPageObject.verificationOfProduct();


    }


}
