package pageAction.desktop;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import pageAction.BasePageActions;
import pageAction.BrowserActions;
import pageObject.desktop.ControlPanel;
import webDriver.Driver;

import java.util.List;

public class FiltersPanel extends BasePageActions {

    public static class ApplyBtn {
        public static void click() {
            try {
                scrollToElement(ControlPanel.applyBtnEnabled());
                ControlPanel.applyBtnEnabled().click();
            } catch (Exception e) {
                System.out.println("Apply button is either not visible or disabled");
            }
        }

        public static void enabledStatus(boolean isEnabled) {
            if (isEnabled) {
                ControlPanel.applyBtnEnabled().isDisplayed();
            } else {
                ControlPanel.applyBtnDisabled().isDisplayed();
            }
        }
    }

    public static class FiltersLink {
        public static void clickMore() {
            try {
                ControlPanel.moreFiltersLink().click();
            } catch (Exception e) {
                System.out.println("Filters are already expanded or 'More Filters' link was not found!");
            }
        }

        public static void clickHide() {
            try {
                ControlPanel.hideFiltersLink().click();
            } catch (Exception e) {
                System.out.println("Filters are already collapsed or 'Hide Filters' link was not found!");
            }
        }
    }

    public static class StatusFilter {
        public static void click() {
            Driver.waitForElement(ControlPanel.statusFilterDescription());
            ControlPanel.statusFilterDescription().click();
        }

        public static String getDescription() {
            return ControlPanel.statusFilterDescription().getText();
        }

        public static void verifySelected(String currentValue) {
            Assert.assertTrue(getDescription().equalsIgnoreCase(currentValue));
        }
    }

    public static class TasksFilter {
        public static void click() {
            Driver.waitForElement(ControlPanel.tasksFilterDescription());
            ControlPanel.tasksFilterDescription().click();
        }

        public static String getDescription() {
            return ControlPanel.tasksFilterDescription().getText();
        }

        public static void verifySelected(String currentValue) {
            Assert.assertTrue(getDescription().equalsIgnoreCase(currentValue));
        }
    }

    public static class UsersFilter {
        public static void click() {
            Driver.waitForElement(ControlPanel.usersFilterDescription());
            ControlPanel.usersFilterDescription().click();
        }

        public static String getDescription() {
            return ControlPanel.usersFilterDescription().getText();
        }

        public static void verifySelected(String currentValue) {
            Assert.assertTrue(getDescription().equalsIgnoreCase(currentValue));
        }
    }

    public static class FiltersPopup{
        public static void clickEnterBtn() {
            ControlPanel.enterBtnFilterPopUp().click();
        }

        public static void clickCancelBtn() {
            ControlPanel.cancelBtnFilterPopUp().click();
        }

        public static void checkParentOption(String parentOptionName) {
            //TODO: verify if it already checked
            ControlPanel.uncheckedFilterParentOption(parentOptionName).click();
        }

        public static void uncheckParentOption(String parentOptionName) {
            //TODO: verify if it already unchecked
            ControlPanel.checkedFilterParentOption(parentOptionName).click();
        }

        public static void checkChildOption(String childOptionName) {
            //TODO: verify if it already checked
            scrollTo(childOptionName);
            ControlPanel.uncheckedFilterChildOption(childOptionName).click();
        }

        public static void uncheckChildOption(String childOptionName) {
            //TODO: verify if it already unchecked
            scrollTo(childOptionName);
            ControlPanel.checkedFilterChildOption(childOptionName).click();
        }

        public static void verifyParentIsChecked(String parentOptionName, boolean isChecked) {
            if (isChecked) {
                ControlPanel.checkedFilterParentOption(parentOptionName);
            } else {
                ControlPanel.uncheckedFilterParentOption(parentOptionName);
            }
        }

        public static void verifyChildIsChecked(String childOptionName, boolean isChecked) {
            if (isChecked) {
                ControlPanel.checkedFilterChildOption(childOptionName);
            } else {
                ControlPanel.uncheckedFilterChildOption(childOptionName);
            }
        }

        public static void verifyOptionsCheckedStatus(DataTable filterOptionsList) {
            List<List<String>> optionList = filterOptionsList.raw();

            for (List<String> option : optionList) {
                String optionName = option.get(0);
                String optionStatus = option.get(1);
                switch (optionStatus) {
                    case "checked":
                        ControlPanel.checkedFilterChildOption(optionName);
                        break;
                    case "unchecked":
                        ControlPanel.uncheckedFilterChildOption(optionName);
                }
            }
        }

        public static void scrollTo(String filterName) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='overview-scroll']//span[text()='" + filterName + "']")));
        }
    }

    public static class ActiveFilters{
        public static String getText() {
            return ControlPanel.activeFilters().getText();
        }

        public static void verifyCurrent(String expectedValue) {
            scrollToElement(ControlPanel.controlHeader());
            Assert.assertTrue(getText().equalsIgnoreCase(expectedValue));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public static void verifyFilterIsMissing(String filterName) throws Exception {
        Assert.assertTrue(filterIsMissing(filterName));
    }

    public static boolean filterIsMissing(String filterName) throws Exception {
        switch (filterName) {
            case "Status":
                try {
                    ControlPanel.statusFilterDescription();
                } catch (NoSuchElementException e) {
                    return true;
                }
                return false;
            case "Tasks":
                try {
                    ControlPanel.tasksFilterDescription();
                } catch (NoSuchElementException e) {
                    return true;
                }
                return false;
            case "Users":
                try {
                    ControlPanel.usersFilterDescription();
                } catch (NoSuchElementException e) {
                    return true;
                }
                return false;
            default:
                throw new Exception("You have indicated wrong filter name. Allowed options: [\"Status\",\"Tasks\",\"Users\"]");
        }
    }

    public static void resetAllFilters() throws InterruptedException {
        FiltersLink.clickMore();
        if (!StatusFilter.getDescription().equalsIgnoreCase("All statuses")) {
            StatusFilter.click();
            FiltersPopup.checkParentOption("All");
            ControlPanel.enterBtnFilterPopUp().click();
        }
        if (!TasksFilter.getDescription().equalsIgnoreCase("Any task")) {
            TasksFilter.click();
            FiltersPopup.checkParentOption("All");
            ControlPanel.enterBtnFilterPopUp().click();
        }
        if (!UsersFilter.getDescription().equalsIgnoreCase("All")) {
            UsersFilter.click();
            FiltersPopup.checkParentOption("All");
            ControlPanel.enterBtnFilterPopUp().click();
        }
        ApplyBtn.click();
        BrowserActions.waitForPageLoadingIsCompleted();
    }
}