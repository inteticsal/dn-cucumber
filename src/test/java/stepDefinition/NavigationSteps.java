package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageAction.BasePageActions;
import pageAction.BrowserActions;
import testRunner.TestRunner;

public class NavigationSteps {
    @Given("^I open URL \"([^\"]*)\"$")
    public void iOpenUrl(String webURL) throws Throwable {
        BrowserActions.openUrl(webURL);
    }

    @When("^I open a browser and go to (desktop|mobile) login page$")
    public void iOpenDesktopVersionOfSite(String siteVersion) throws Throwable {
        String url = null;
        switch (siteVersion) {
            case "desktop":
                url = TestRunner.config.get("siteUrl");
                TestRunner.isMobile = false;
                break;
            case "mobile":
                url = TestRunner.config.get("mobileSiteUrl");
                TestRunner.isMobile = true;
                break;
        }
        BrowserActions.openUrl(url);
    }

    @Then("^I am at \"([^\"]*)\" page$")
    public void iAmAtPage(String expectedHeader) throws Throwable {
        BrowserActions.waitForPageLoadingIsCompleted();
        Assert.assertTrue(BasePageActions.getControlHeaderName().equalsIgnoreCase(expectedHeader));
    }

}