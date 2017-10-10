package pageAction.desktop;

import pageAction.BasePageActions;
import pageObject.desktop.StoryIdeasPage;

public class StoryIdeas extends BasePageActions {
    public static void verifyTextInSection(String text, String section) {
        StoryIdeasPage.textInSection(text, section);
    }
}
