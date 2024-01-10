package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OffersPageObject {
   /*
Page Object is used to keep our webelements placed in a class which is created for particular so that
    our code will be much readable and loosely coupled
    */
    public WebDriver driver;
    By toOfferSearch = By.cssSelector("div input#search-field");
    By verifyProduct = By.xpath("(//table/tbody/tr/td)[1]");
    String prodOfferPage;
    String offersPagePro = "Tomato";
    public String parentWindow ;
    String childWindow;

    public OffersPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToChildWindow() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
         parentWindow = it.next();
         childWindow = it.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(2000);
    }
    public  void searchProduct(String prod) throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(toOfferSearch)).click().keyDown(Keys.LEFT_SHIFT).sendKeys(prod).build().perform();
        Thread.sleep(4000);
    }
    public  String verificationOfProduct(){
        prodOfferPage = driver.findElement(verifyProduct).getText();
        System.out.println(prodOfferPage);
        return prodOfferPage;

    }
    public void verificationInOffersPageForProduct() {
        Assert.assertEquals(prodOfferPage, offersPagePro);
        System.out.println("Verification in offer page is done and product exist");
    }
    }

