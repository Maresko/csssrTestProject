package global.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import csssr.pageobject.JobPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import global.Drivers;
import helpers.AbstractPage;
import helpers.Wait;
import org.openqa.selenium.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;


public class GlobalSteps {

    Wait waiter = new Wait();
    public Drivers drvs = new Drivers();

    JobPage jobPage = null;
    AbstractPage currentPage = null;
    SelenideElement elem = null;

    private AbstractPage getCurrentPage (String pageName){
        if ("job page".equals(pageName)){
            return currentPage = jobPage;
        }
        else{
            return currentPage;
        }
    }

    @Given("^open Chrome browser$")
    public void openChromeMobileBrowser() throws Throwable {
        WebDriverRunner.setWebDriver(drvs.getChromeDriver());
        jobPage = page(JobPage.class);
    }

    @Then("^verify that page with url which contains \"([^\"]*)\" is opened$")
    public void verifyThatPageWithUrlWhichContainsIsOpened(String verifyUrl)
    {
        waiter.waitUntilUrlContant(verifyUrl);
        String currentUrl = url();
        if(!currentUrl.contains(verifyUrl))
        {
            Assert.fail("login page didn't opened");
        }
    }

    @Then("^verify that page with url which \"([^\"]*)\" is opened$")
    public void verifyThatPageWithUrlIsOpened(String verifyUrl)
    {
        waiter.waitUntilUrlContant(verifyUrl);
        String currentUrl = url();
        if(!currentUrl.equals(verifyUrl))
        {
            Assert.fail("login page didn't opened");
        }
    }

    @Given("^open page \"([^\"]*)\"$")
    public void openTopupPageOnMSite(String url) throws Throwable {
        open(url);
    }

    @And("^click element \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void clickElement(String element, String page) throws Throwable {
        elem = getCurrentPage(page).get(element).shouldBe(Condition.visible);
        waiter.waitUntilClickable(elem);
        elem.click();
    }
}
