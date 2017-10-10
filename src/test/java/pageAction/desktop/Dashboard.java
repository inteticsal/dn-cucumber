package pageAction.desktop;

import pageAction.BasePageActions;
import pageObject.desktop.DashboardPage;

public class Dashboard extends BasePageActions {

    public static void verifyPageIsActive() {
        DashboardPage.treatDashboardElement().isDisplayed();
    }

    public static void verifyItemDisplayedAtStoryList(String storyName) {
        DashboardPage.StoryList.storyTitle(storyName).isDisplayed();
    }
}