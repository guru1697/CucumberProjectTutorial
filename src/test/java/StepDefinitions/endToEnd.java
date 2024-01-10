//package StepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//
//import java.util.Iterator;
//import java.util.Set;
//
//public class endToEnd {
//
//    WebDriver driver;
//    public String landingPagePro;
//    public String offersPagePro;
//
//    @Given("User is on GreenKart landing page")
//    public void user_is_on_green_kart_landing_page() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        String expected = "GreenKart - veg and fruits kart";
//        String pageTitleHome = driver.getTitle();
//        System.out.println(pageTitleHome);
//        Assert.assertEquals(pageTitleHome, expected);
//        System.out.println("User is on landing page");
//    }
//
//    @When("User searched with the short name {string} and extracted the actual name")
//    public void user_searched_with_the_short_name_and_extracted_the_actual_name(String product) {
//        WebElement searchBar = driver.findElement(By.cssSelector("input.search-keyword"));
//        WebElement productFoundHome = driver.findElement(By.cssSelector(".product h4"));
//        try {
//            Actions act = new Actions(driver);
//            act.moveToElement(searchBar).click().keyDown(Keys.LEFT_SHIFT).sendKeys(product).build().perform();
//            Thread.sleep(5000);
//            String productFoundSearch = productFoundHome.getText();
//            System.out.println(productFoundSearch);
//            String productValidate = productFoundSearch.split("-")[0].trim();
//            landingPagePro = "Tomato";
//            Assert.assertEquals(landingPagePro, productValidate);
//
//        } catch (Exception e) {
//            System.out.println("Check the try block and identify issue");
//        }
//
//
//    }
//
//    @Then("User search for same product {string} in offers page to verify if product exist")
//    public void user_search_for_same_product_in_offers_page_to_verify_if_product_exist(String prodName) throws InterruptedException {
//        WebElement toOffers = driver.findElement(By.linkText("Top Deals"));
//        toOffers.click();
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it = windows.iterator();
//        String parentWindow = it.next();
//        String childWindow = it.next();
//        driver.switchTo().window(childWindow);
//        Thread.sleep(2000);
//        WebElement toOfferSearch = driver.findElement(By.cssSelector("div input#search-field"));
//        Actions act = new Actions(driver);
//        act.moveToElement(toOfferSearch).click().keyDown(Keys.LEFT_SHIFT).sendKeys(prodName).build().perform();
//        Thread.sleep(4000);
//        WebElement verifyProduct = driver.findElement(By.xpath("(//table/tbody/tr/td)[1]"));
//        offersPagePro = "Tomato";
//        Assert.assertEquals(verifyProduct.getText(), offersPagePro);
//        System.out.println("Verification in offer page is done and product exist");
//        driver.close();
//        driver.switchTo().window(parentWindow);
//        driver.quit();
//
//
//    }
//
//
//}
