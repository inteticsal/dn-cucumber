package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.StoryCreation;

public class NewStorySteps {
    @And("^I am at new Story creation page$")
    public void iAmAtNewStoryCreationPage() {
        StoryCreation.verifyPageIsActive();
    }

    @And("^I enter Story Description \"([^\"]*)\"$")
    public void iEnterStoryDescription(String storyDescription) {
        StoryCreation.setDescription(storyDescription);
    }

    @And("^I add (Text|Photo|Photo Gallery|Graphic|Video|Audio) task to Story$")
    public void iAddTaskToStory(String storyTaskName) {
        StoryCreation.addTask(storyTaskName);
    }

    @Then("^I click Save Story bottom$")
    public void iClickSaveStoryBottom() {
        StoryCreation.clickSaveBtn();
    }

    @Then("^I click Save Story top link$")
    public void iClickSaveStoryTop() {
        StoryCreation.clickSaveTopLink();
    }

    @Then("^I click (SAVE|SAVE & NEXT|CANCEL) bottom button$")
    public void iClickSAVENEXTCANCELBottomButton(String btnLabel) {
        switch (btnLabel) {
            case "SAVE":
                StoryCreation.clickSaveBtn();
                break;
            case "SAVE & NEXT":
                StoryCreation.clickSaveAndNextBtn();
                break;
            case "Cancel":
                StoryCreation.clickCancelBtn();
                break;
        }
    }

    @And("^I delete first Text article at Tasks Panel$")
    public void iDeleteFirstTextArticleAtTasksPanel() {
        StoryCreation.deleteFirstTextArticle();
    }
}
