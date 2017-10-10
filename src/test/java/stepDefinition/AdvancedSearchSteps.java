package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.AdvancedSearch;

public class AdvancedSearchSteps {
    @Then("^I select (Any user|Limit to these) for 'Assigned to' option$")
    public void iSelectLimitToTheseForAssignedToOption(String option) {
        AdvancedSearch.setAssignedTo(option);
    }

    @And("^I enter \"([^\"]*)\" into advanced search$")
    public void iEnterIntoAdvancedSearch(String text) {
        AdvancedSearch.inputTextForSearch(text);
    }

    @Then("^I click on Search button$")
    public void iClickOnSearchButton() {
        AdvancedSearch.clickSearchButton();
    }

    @And("^I (see|do not see) \"([^\"]*)\" at searching results$")
    public void iSeeAtSearchingResults(String expectation, String text) throws Exception {
        switch (expectation) {
            case "see":
                AdvancedSearch.verifySearchingResult(text, true);
                break;
            case "do not see":
                AdvancedSearch.verifySearchingResult(text, false);
                break;
        }
    }
}