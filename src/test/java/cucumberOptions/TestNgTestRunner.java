package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Feature", glue = "StepDefinitions", monochrome = true, tags = "@FirstTest",
        plugin = {"pretty", "html:target/cucumber.html" , "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
