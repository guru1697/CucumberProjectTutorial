package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LandingPageObject {
    public WebDriver driver;
    By searchBar = By.cssSelector("input.search-keyword");
    By productFoundHome = By.xpath("//div[@class='products']/div[@class='product']/h4");
    String productFound;
    String landingPagePro = "Tomato";
    By toOffers= By.linkText("Top Deals");
    String expected = "GreenKart - veg and fruits kart";
    String pageTitleHome;

    public LandingPageObject(WebDriver driver){
        this.driver = driver;
    }
   /*
Page Object is used to keep our webelements placed in a class which is created for particular so that
    our code will be much readable and loosely coupled
    */

    public void searchItem(String prod) throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(searchBar)).click().keyDown(Keys.LEFT_SHIFT).sendKeys(prod).build().perform();
        Thread.sleep(5000);
    }
    public  String getProductText(){
        productFound = driver.findElement(productFoundHome).getText().split("-")[0].trim();
        System.out.println(productFound);
        return productFound;
    }
    public  void verificationOfProduct(){
        Assert.assertEquals(productFound,landingPagePro);
        System.out.println(landingPagePro);

    }

    public void toOffers(){
        driver.findElement(toOffers).click();
    }

    public void getPageTitle(){
        pageTitleHome = driver.getTitle();
        System.out.println(pageTitleHome);
        Assert.assertEquals(pageTitleHome, expected);
        System.out.println("User is on landing page");
    }

}
