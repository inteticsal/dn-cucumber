package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;

public class NavPanel extends BasePageActions {
    public static String getSelectedTopPanelMenuItem() {
        return pageObject.desktop.NavPanel.selectedMenuItem().getText();
    }

    public static void verifySelectedMenu(String menuItemLabel) {
        Assert.assertTrue(NavPanel.getSelectedTopPanelMenuItem().equalsIgnoreCase(menuItemLabel));
    }

    public static void clickOnAdvancedSearchLink() throws InterruptedException {
        waitForPageLoadingIsCompleted();
        pageObject.desktop.NavPanel.searchIcon().click();
        wait.until(ExpectedConditions.elementToBeClickable(pageObject.desktop.NavPanel.advancedSearchLink()));
        pageObject.desktop.NavPanel.advancedSearchLink().click();
    }

    public static void clickImageLogo() {
        pageObject.desktop.NavPanel.imageLogo().click();
    }

    public static void createNewItem(String itemName) {
        pageObject.desktop.NavPanel.callItemsToCreatePopUp().click();
        pageObject.desktop.NavPanel.selectItemToCreatePopUp(itemName).click();
    }

    public static void navigateTo(String navigationItem) throws InterruptedException {
        //TODO: handle hamburger menu first if displayed
        switch (navigationItem) {
            case "Dashboard":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Story List":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Story - planning":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Story Lists"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Story planning").click();
                break;
            case "Story - Short-term":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Story Lists"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Story - Long-term":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Story Lists"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Long-term").click();
                break;
            case "Story - Ideas":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Story Lists"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Story Ideas").click();
                break;
            case "Story - Topics":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Story Lists"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Topics").click();
                break;
            case "Tasks":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Calendar":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Calendar - Editorial events":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Calendar"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Editorial events").click();
                break;
            case "Calendar - Short-term":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Calendar"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Calendar - Long-term":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Calendar"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Long-term").click();
                break;
            case "Calendar - Event Feeds":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Calendar"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Event Feeds").click();
                break;
            case "Management":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Management - Availability":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Availability").click();
                break;
            case "Management - Short-term":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Management - Monthly":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Monthly").click();
                break;
            case "Management - Timeline":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Timeline").click();
                break;
            case "Management - Shifts":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Shifts").click();
                break;
            case "Management - Inbox":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Inbox").click();
                break;
            case "Management - Alerts":
                callSecondaryMenuForNavigationItem(pageObject.desktop.NavPanel.mainMenuNavigationItem("Management"));
                pageObject.desktop.NavPanel.secondaryMenuNavigationItem("Alerts").click();
                break;
            case "My Schedule":
                pageObject.desktop.NavPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Advanced Search":
                clickOnAdvancedSearchLink();
                break;
        }
    }

    public static void callSecondaryMenuForNavigationItem(WebElement ele) {
        action.moveToElement(ele).perform();
    }
}
