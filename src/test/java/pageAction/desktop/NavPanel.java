package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageAction.BrowserActions;
import pageObject.desktop.NavigationPanel;

public class NavPanel extends BasePageActions {
    public static String getSelectedTopPanelMenuItem() {
        return NavigationPanel.selectedMenuItem().getText();
    }

    public static void verifySelectedMenu(String menuItemLabel) {
        Assert.assertTrue(NavPanel.getSelectedTopPanelMenuItem().equalsIgnoreCase(menuItemLabel));
    }

    public static void clickOnAdvancedSearchLink() throws InterruptedException {
        waitForPageLoadingIsCompleted();
        NavigationPanel.searchIcon().click();
        wait.until(ExpectedConditions.elementToBeClickable(NavigationPanel.advancedSearchLink()));
        NavigationPanel.advancedSearchLink().click();
    }

    public static void clickImageLogo() {
        NavigationPanel.imageLogo().click();
    }

    public static void createNewItem(String itemName) {
        NavigationPanel.callItemsToCreatePopUp().click();
        NavigationPanel.selectItemToCreatePopUp(itemName).click();
    }

    public static void navigateTo(String navigationItem) throws InterruptedException {
        //TODO: handle hamburger menu first if displayed
        switch (navigationItem) {
            case "Dashboard":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Story List":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Story - planning":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Story Lists"));
                NavigationPanel.secondaryMenuNavigationItem("Story planning").click();
                break;
            case "Story - Short-term":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Story Lists"));
                NavigationPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Story - Long-term":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Story Lists"));
                NavigationPanel.secondaryMenuNavigationItem("Long-term").click();
                break;
            case "Story - Ideas":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Story Lists"));
                NavigationPanel.secondaryMenuNavigationItem("Story Ideas").click();
                break;
            case "Story - Topics":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Story Lists"));
                NavigationPanel.secondaryMenuNavigationItem("Topics").click();
                break;
            case "Tasks":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Calendar":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Calendar - Editorial events":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Calendar"));
                NavigationPanel.secondaryMenuNavigationItem("Editorial events").click();
                break;
            case "Calendar - Short-term":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Calendar"));
                NavigationPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Calendar - Long-term":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Calendar"));
                NavigationPanel.secondaryMenuNavigationItem("Long-term").click();
                break;
            case "Calendar - Event Feeds":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Calendar"));
                NavigationPanel.secondaryMenuNavigationItem("Event Feeds").click();
                break;
            case "Management":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Management - Availability":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Availability").click();
                break;
            case "Management - Short-term":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Short-term").click();
                break;
            case "Management - Monthly":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Monthly").click();
                break;
            case "Management - Timeline":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Timeline").click();
                break;
            case "Management - Shifts":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Shifts").click();
                break;
            case "Management - Inbox":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Inbox").click();
                break;
            case "Management - Alerts":
                callSecondaryMenuForNavigationItem(NavigationPanel.mainMenuNavigationItem("Management"));
                NavigationPanel.secondaryMenuNavigationItem("Alerts").click();
                break;
            case "My Schedule":
                NavigationPanel.mainMenuNavigationItem(navigationItem).click();
                break;
            case "Advanced Search":
                clickOnAdvancedSearchLink();
                break;
        }
        if (!navigationItem.equalsIgnoreCase("Advanced Search")) {
            BrowserActions.waitForPageLoadingIsCompleted();
        }
    }

    public static void logout() {
        NavigationPanel.logoutBtn().click();
    }

    private static void callSecondaryMenuForNavigationItem(WebElement ele) {
        action.moveToElement(ele).perform();
    }
}
