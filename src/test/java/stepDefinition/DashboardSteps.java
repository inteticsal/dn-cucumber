package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.BrowserActions;
import pageAction.desktop.Dashboard;

public class DashboardSteps {
    @Then("^I am at Dashboard page$")
    public void iAmAtDashboardPage() throws Throwable {
        BrowserActions.waitForPageLoadingIsCompleted();
        Dashboard.verifyPageIsActive();
    }

    @And("^I verify that \"([^\"]*)\" displayed at Story List$")
    public void iVerifyThatDisplayedAtStoryList(String storyTitle) throws Throwable {
        Dashboard.verifyItemDisplayedAtStoryList(storyTitle);
    }
}
