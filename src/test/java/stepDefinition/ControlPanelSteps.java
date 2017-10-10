package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.FiltersPanel;
import pageAction.mobile.mControlPanelActions;
import testRunner.TestRunner;

public class ControlPanelSteps {
    @And("^I click (open|hide) filters at Control Panel$")
    public void iClickMoreFiltersLinkAtControlPanel(String action) throws InterruptedException {
        if (TestRunner.isMobile) {
            switch (action) {
                case "open":
                    mControlPanelActions.clickMoreFiltersLink();
                    break;
                case "hide":
                    mControlPanelActions.clickHideFiltersLink();
                    break;
            }
        } else {
            switch (action) {
                case "open":
                    FiltersPanel.FiltersLink.clickMore();
                    break;
                case "hide":
                    FiltersPanel.FiltersLink.clickHide();
                    break;
            }
        }
    }

    @And("^I click hide filters at Control Panel$")
    public void iClickHideFiltersLinkAtControlPanel() {

    }

    @Then("^I verify that (Status|Tasks|Users) additional filter has \"([^\"]*)\" value$")
    public void iVerifyThatAdditionalFilterHasValue(String filterName, String filterValue) throws Throwable {
        switch (filterName) {
            case "Status":
                FiltersPanel.StatusFilter.verifySelected(filterValue);
                break;
            case "Tasks":
                FiltersPanel.TasksFilter.verifySelected(filterValue);
                break;
            case "Users":
                FiltersPanel.UsersFilter.verifySelected(filterValue);
                break;
            default:
                throw new Exception("You have indicated wrong filter name. Allowed options: [\"Status\",\"Tasks\",\"Users\"]");
        }
    }

    @Then("^I click on (Status|Tasks|Users) filter$")
    public void iClickOnFilterName(String filterName) {
        switch (filterName) {
            case "Status":
                FiltersPanel.StatusFilter.click();
                break;
            case "Tasks":
                FiltersPanel.TasksFilter.click();
                break;
            case "Users":
                FiltersPanel.UsersFilter.click();
                break;
        }
    }

    @And("^I verify that parent filter option \"([^\"]*)\" is (checked|unchecked)$")
    public void iVerifyThatValueIsPresentedAndChecked(String optionName, String verifyStatus) {
        switch (verifyStatus) {
            case "checked":
                FiltersPanel.FiltersPopup.verifyParentIsChecked(optionName, true);
                break;
            case "unchecked":
                FiltersPanel.FiltersPopup.verifyParentIsChecked(optionName, false);
                break;
        }
    }

    @And("^I verify that child filter option \"([^\"]*)\" is (checked|unchecked)$")
    public void iVerifyThatChildFilterOptionIsChecked(String optionName, String verifyStatus) {
        switch (verifyStatus) {
            case "checked":
                FiltersPanel.FiltersPopup.verifyChildIsChecked(optionName, true);
                break;
            case "unchecked":
                FiltersPanel.FiltersPopup.verifyChildIsChecked(optionName, false);
                break;
        }
    }

    @And("^I verify child filter options checked status$")
    public void iVerifyThatChildFilterOptionIs(DataTable filterOptionsList) {
        FiltersPanel.FiltersPopup.verifyOptionsCheckedStatus(filterOptionsList);
    }

    @And("^I press (ENTER|CANCEL) in filters pop-up$")
    public void iPressENTERorCANCELInFiltersPopUp(String btnName) {
        switch (btnName) {
            case "ENTER":
                FiltersPanel.FiltersPopup.clickEnterBtn();
                break;
            case "CANCEL":
                FiltersPanel.FiltersPopup.clickCancelBtn();
                break;
        }
    }

    @And("^I verify APPLY filters button is (enabled|disabled)$")
    public void iVerifyAPPLYFiltersButtonIsDisabled(String btnState) {
        switch (btnState) {
            case "enabled":
                FiltersPanel.ApplyBtn.enabledStatus(true);
                break;
            case "disabled":
                FiltersPanel.ApplyBtn.enabledStatus(false);
                break;
        }
    }

    @And("^I click APPLY filters button$")
    public void iClickAPPLYFiltersButton() {
        FiltersPanel.ApplyBtn.click();
    }

    @And("^I uncheck All filters$")
    public void iUncheckAllFilters() {
        FiltersPanel.FiltersPopup.uncheckParentOption("All");
    }

    @And("^I check All filters$")
    public void iCheckAllFilters() {
        FiltersPanel.FiltersPopup.checkParentOption("All");
    }

    @And("^I check \"([^\"]*)\" filter$")
    public void iCheckFilter(String filterName) {
        FiltersPanel.FiltersPopup.checkChildOption(filterName);
    }

    @And("^I uncheck \"([^\"]*)\" filter$")
    public void iUncheckFilter(String filterName) {
        FiltersPanel.FiltersPopup.uncheckChildOption(filterName);
    }

    @And("^I see active filters: \"([^\"]*)\"$")
    public void iSeeActiveFilters(String expectedFilters) {
        FiltersPanel.ActiveFilters.verifyCurrent(expectedFilters);
    }

    @And("^I reset all Dashboard filters$")
    public void iResetAllDashboardFilters() throws InterruptedException {
        FiltersPanel.resetAllFilters();
    }

    @Then("^I scroll filters to \"([^\"]*)\"$")
    public void iScrollFiltersTo(String filterName) {
        FiltersPanel.FiltersPopup.scrollTo(filterName);
    }

    @And("^I do not see (Status|Tasks|Users) filter$")
    public void iDoNotSeeStatusTasksUsersFilter(String filterName) throws Exception {
        FiltersPanel.verifyFilterIsMissing(filterName);
    }
}
