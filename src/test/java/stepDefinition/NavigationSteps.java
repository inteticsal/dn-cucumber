package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageAction.CommonPageActions;
import pageAction.BrowserActions;

public class NavigationSteps {
    @Given("^I open URL \"([^\"]*)\"$")
    public void iOpenUrl(String webURL) throws Throwable {
        BrowserActions.openUrl(webURL);
    }

    @When("^I open a desktop version of site$")
    public void iOpenDesktopVersionOfSite() throws Throwable {
        String desktopUrl = "https://vm06.atwss.com:8443/login.htm";
        BrowserActions.openUrl(desktopUrl);
    }

    @When("^I open a mobile version of site$")
    public void iOpenMobileVersionOfSite() throws Throwable {
        String desktopUrl = "https://vm06.atwss.com:8443/m/login.htm";
        BrowserActions.openUrl(desktopUrl);
    }

    @Then("^I am at \"([^\"]*)\" page$")
    public void iAmAtPage(String expectedHeader) throws Throwable {
        Assert.assertTrue(CommonPageActions.getControlHeaderName().equalsIgnoreCase(expectedHeader));
    }
}