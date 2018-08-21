package csssr;

import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Steps {

    @Then("^check that checkbox is on$")
    public void checkThatElementStatusOfCheckbox() throws Throwable {
        WebDriver driver = getWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String sText = js.executeScript("return document.getElementById('beautiful').checked").toString();
        Assert.assertEquals(sText, "true");
    }
}

