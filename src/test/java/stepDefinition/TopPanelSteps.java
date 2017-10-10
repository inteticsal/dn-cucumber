package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageAction.desktop.NavPanel;
import pageAction.mobile.mNavPanelActions;
import testRunner.TestRunner;

public class TopPanelSteps {
    @And("^I verify that \"([^\"]*)\" is selected in navigation panel menu$")
    public void iVerifyThatIsSelectedInNavigationPanelMenu(String expectedMenuItem) {
        NavPanel.verifySelectedMenu(expectedMenuItem);
    }

    @Then("^I create a new (Story|Event|Note|Absence|Shift|Topic)$")
    public void iCreateNewStory(String itemToCreate) {
        NavPanel.createNewItem(itemToCreate);
    }

    @When("^I click on logo image$")
    public void iClickOnLogoImage() {
        NavPanel.clickImageLogo();
    }

    @Then("^I navigate to (Dashboard|Story List|Tasks|Calendar|Management|My Schedule|Advanced Search)$")
    public void iNavigateToDashboard(String mainItemName) throws InterruptedException {
        if (TestRunner.isMobile) {
            mNavPanelActions.navigateTo(mainItemName);
        } else {
            NavPanel.navigateTo(mainItemName);
        }
    }

    @Then("^I navigate to (Story - planning|Story - Short-term|Story - Long-term|Story - Ideas|Story - Topics)$")
    public void iNavigateToStoryListsSubMenu(String subItemName) throws InterruptedException {
        NavPanel.navigateTo(subItemName);
    }

    @Then("^I navigate to (Calendar - Editorial events|Calendar - Short-term|Calendar - Long-term|Calendar - Event Feeds)$")
    public void iNavigateToCalendarSubMenu(String subItemName) throws InterruptedException {
        NavPanel.navigateTo(subItemName);
    }

    @Then("^I navigate to (Management - Availability|Management - Short-term|Management - Monthly|Management - Timeline|Management - Shifts|Management - Inbox|Management - Alerts)$")
    public void iNavigateToManagementSubMenu(String subItemName) throws InterruptedException {
        NavPanel.navigateTo(subItemName);
    }
}