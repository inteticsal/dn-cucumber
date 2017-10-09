package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.ControlPanelActions;
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
                    ControlPanelActions.clickMoreFiltersLink();
                    break;
                case "hide":
                    ControlPanelActions.clickHideFiltersLink();
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
                ControlPanelActions.verifyStatusFilterSelectedValue(filterValue);
                break;
            case "Tasks":
                ControlPanelActions.verifyTasksFilterSelectedValue(filterValue);
                break;
            case "Users":
                ControlPanelActions.verifyUsersFilterSelectedValue(filterValue);
                break;
            default:
                throw new Exception("You have indicated wrong filter name. Allowed options: [\"Status\",\"Tasks\",\"Users\"]");
        }
    }

    @Then("^I click on (Status|Tasks|Users) filter$")
    public void iClickOnFilterName(String filterName) {
        switch (filterName) {
            case "Status":
                ControlPanelActions.clickStatusDescription();
                break;
            case "Tasks":
                ControlPanelActions.clickTasksDescription();
                break;
            case "Users":
                ControlPanelActions.clickUsersDescription();
                break;
        }
    }

    @And("^I verify that parent filter option \"([^\"]*)\" is (checked|unchecked)$")
    public void iVerifyThatValueIsPresentedAndChecked(String optionName, String verifyStatus) {
        switch (verifyStatus) {
            case "checked":
                ControlPanelActions.verifyParentFilterIsChecked(optionName, true);
                break;
            case "unchecked":
                ControlPanelActions.verifyParentFilterIsChecked(optionName, false);
                break;
        }
    }

    @And("^I verify that child filter option \"([^\"]*)\" is (checked|unchecked)$")
    public void iVerifyThatChildFilterOptionIsChecked(String optionName, String verifyStatus) {
        switch (verifyStatus) {
            case "checked":
                ControlPanelActions.verifyChildFilterIsChecked(optionName, true);
                break;
            case "unchecked":
                ControlPanelActions.verifyChildFilterIsChecked(optionName, false);
                break;
        }
    }

    @And("^I verify child filter options checked status$")
    public void iVerifyThatChildFilterOptionIs(DataTable filterOptionsList) {
        ControlPanelActions.verifyFilterOptionsCheckedStatus(filterOptionsList);
    }

    @And("^I press (ENTER|CANCEL) in filters pop-up$")
    public void iPressENTERorCANCELInFiltersPopUp(String btnName) {
        switch (btnName) {
            case "ENTER":
                ControlPanelActions.clickEnterBtnPopUp();
                break;
            case "CANCEL":
                ControlPanelActions.clickCancelBtnPopUp();
                break;
        }
    }

    @And("^I verify APPLY filters button is (enabled|disabled)$")
    public void iVerifyAPPLYFiltersButtonIsDisabled(String btnState) {
        switch (btnState) {
            case "enabled":
                ControlPanelActions.verifyApplyBtnEnabledStatus(true);
                break;
            case "disabled":
                ControlPanelActions.verifyApplyBtnEnabledStatus(false);
                break;
        }
    }

    @And("^I click APPLY filters button$")
    public void iClickAPPLYFiltersButton() {
        ControlPanelActions.clickApplyBtn();
    }

    @And("^I uncheck All filters$")
    public void iUncheckAllFilters() {
        ControlPanelActions.uncheckFilterParentOption("All");
    }

    @And("^I check All filters$")
    public void iCheckAllFilters() {
        ControlPanelActions.checkFilterParentOption("All");
    }

    @And("^I check \"([^\"]*)\" filter$")
    public void iCheckFilter(String filterName) {
        ControlPanelActions.checkFilterChildOption(filterName);
    }

    @And("^I uncheck \"([^\"]*)\" filter$")
    public void iSelectFilter(String filterName) {
        ControlPanelActions.uncheckFilterChildOption(filterName);
    }

    @And("^I see active filters: \"([^\"]*)\"$")
    public void iSeeActiveFilters(String expectedFilters) {
        ControlPanelActions.verifyActiveFilters(expectedFilters);
    }

    @And("^I reset all Dashboard filters$")
    public void iResetAllDashboardFilters() throws InterruptedException {
        ControlPanelActions.resetAllFilters();
    }

    @Then("^I scroll filters to \"([^\"]*)\"$")
    public void iScrollFiltersTo(String filterName) {
        ControlPanelActions.scrollFiltersTo(filterName);
    }

    @And("^I do not see (Status|Tasks|Users) filter$")
    public void iDoNotSeeStatusTasksUsersFilter(String filterName) throws Exception {
        ControlPanelActions.verifyFilterIsMissing(filterName);
    }
}
