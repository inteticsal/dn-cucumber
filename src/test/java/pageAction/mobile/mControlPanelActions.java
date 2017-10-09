package pageAction.mobile;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pageAction.BasePageActions;
import pageObject.mobile.mControlPanel;
import webDriver.Driver;

import java.util.List;

public class mControlPanelActions extends BasePageActions {

    public static void clickMoreFiltersLink() throws InterruptedException {
        try {
            mControlPanel.moreFiltersLink().click();
        } catch (Exception e) {
            System.out.println("Filters are already expanded or 'More Filters' link was not found!");
        }
    }

    public static void clickHideFiltersLink() throws InterruptedException {
        try {
            mControlPanel.hideFiltersLink().click();
        } catch (Exception e) {
            System.out.println("Filters are already collapsed or 'Hide Filters' link was not found!");
        }
    }

    public static void clickStatusDescription() {
        Driver.waitForElement(mControlPanel.statusFilterDescription());
        mControlPanel.statusFilterDescription().click();
    }

    public static void clickTasksDescription() {
        Driver.waitForElement(mControlPanel.tasksFilterDescription());
        mControlPanel.tasksFilterDescription().click();
    }

    public static void clickGroupsDescription() {
        Driver.waitForElement(mControlPanel.groupsFilterDescription());
        mControlPanel.groupsFilterDescription().click();
    }

    public static void clickPlatformsDescription() {
        Driver.waitForElement(mControlPanel.platformsFilterDescription());
        mControlPanel.platformsFilterDescription().click();
    }

    public static void clickEnterBtnPopUp() {
        mControlPanel.enterBtnFilterPopUp().click();
    }

    public static void clickCancelBtnPopUp() {
        mControlPanel.cancelBtnFilterPopUp().click();
    }

    public static void checkFilterParentOption(String parentOptionName) {
        //TODO: verify if it already checked
        mControlPanel.uncheckedFilterParentOption(parentOptionName).click();
    }

    public static void uncheckFilterParentOption(String parentOptionName) {
        //TODO: verify if it already unchecked
        mControlPanel.checkedFilterParentOption(parentOptionName).click();
    }

    public static void checkFilterChildOption(String childOptionName) {
        //TODO: verify if it already checked
        scrollFiltersTo(childOptionName);
        mControlPanel.uncheckedFilterChildOption(childOptionName).click();
    }

    public static void uncheckFilterChildOption(String childOptionName) {
        //TODO: verify if it already unchecked
        scrollFiltersTo(childOptionName);
        mControlPanel.checkedFilterChildOption(childOptionName).click();
    }

    public static String getStatusFilterDescription() {
        return mControlPanel.statusFilterDescription().getText();
    }

    public static String getTasksFilterDescription() {
        return mControlPanel.tasksFilterDescription().getText();
    }

    public static String getGroupsFilterDescription() {
        return mControlPanel.groupsFilterDescription().getText();
    }

    public static String getPlatformsFilterDescription() {
        return mControlPanel.platformsFilterDescription().getText();
    }

    public static String getActiveFiltersText() {
        return mControlPanel.activeFilters().getText();
    }

    public static void verifyStatusFilterSelectedValue(String currentStatus) {
        Assert.assertTrue(getStatusFilterDescription().equalsIgnoreCase(currentStatus));
    }

    public static void verifyTasksFilterSelectedValue(String currentStatus) {
        Assert.assertTrue(getTasksFilterDescription().equalsIgnoreCase(currentStatus));
    }

    public static void verifyGroupsFilterSelectedValue(String currentStatus) {
        Assert.assertTrue(getGroupsFilterDescription().equalsIgnoreCase(currentStatus));
    }

    public static void verifyPlatformsFilterSelectedValue(String currentStatus) {
        Assert.assertTrue(getPlatformsFilterDescription().equalsIgnoreCase(currentStatus));
    }

    public static void verifyParentFilterIsChecked(String parentOptionName, boolean isChecked) {
        if (isChecked) {
            mControlPanel.checkedFilterParentOption(parentOptionName);
        } else {
            mControlPanel.uncheckedFilterParentOption(parentOptionName);
        }
    }

    public static void verifyChildFilterIsChecked(String childOptionName, boolean isChecked) {
        if (isChecked) {
            mControlPanel.checkedFilterChildOption(childOptionName);
        } else {
            mControlPanel.uncheckedFilterChildOption(childOptionName);
        }
    }

    public static void verifyFilterOptionsCheckedStatus(DataTable filterOptionsList) {
        List<List<String>> optionList = filterOptionsList.raw();

        for (List<String> option : optionList) {
            String optionName = option.get(0);
            String optionStatus = option.get(1);
            switch (optionStatus) {
                case "checked":
                    mControlPanel.checkedFilterChildOption(optionName);
                    break;
                case "unchecked":
                    mControlPanel.uncheckedFilterChildOption(optionName);
            }
        }
    }

    public static void verifyActiveFilters(String expectedValue) {
        scrollToElement(mControlPanel.controlHeader());
        Assert.assertTrue(getActiveFiltersText().equalsIgnoreCase(expectedValue));
    }

    public static void scrollFiltersTo(String filterName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='overview-scroll']//span[text()='" + filterName + "']")));
    }

    public static void resetAllFilters() throws InterruptedException {
    }
}