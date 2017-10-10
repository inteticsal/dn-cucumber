package stepDefinition;

import cucumber.api.java.en.And;
import pageAction.desktop.StoryIdeas;

public class StoryIdeasSteps {
    @And("^I see \"([^\"]*)\" at \"([^\"]*)\" Story Idea section$")
    public void iSeeAtStoryIdeaSection(String text, String sectionName) throws Throwable {
        StoryIdeas.verifyTextInSection(text, sectionName);
    }
}
