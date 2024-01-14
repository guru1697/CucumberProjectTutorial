package StepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void AfterScenario() {
        testContextSetup.pageObjectManager.driver.quit();
    }
}
