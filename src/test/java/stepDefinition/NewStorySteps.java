package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.StoryCreationPageActions;
import pageObject.StoryCreationPage;
import webDriver.Driver;

public class NewStorySteps {
    @And("^I am at new Story creation page$")
    public void iAmAtNewStoryCreationPage() throws Throwable {
        StoryCreationPage.treatStoryCreationPage().isDisplayed();
    }

    @And("^I enter Story Description \"([^\"]*)\"$")
    public void iEnterStoryDescription(String text) throws Throwable {
        StoryCreationPage.descriptionTextArea().sendKeys(Driver.timeStamp + "-" + text);
    }

    @And("^I add (Text|Photo|Photo Gallery|Graphic|Video|Audio) task to Story$")
    public void iAddTaskToStory(String itemName) throws Throwable {
        switch (itemName){
            case "Text":
                StoryCreationPage.addTextIcon().click();
                break;
            case "Photo":
                StoryCreationPage.addPhotoIcon().click();
                break;
            case "Photo Gallery":
                StoryCreationPage.addPhotoGalleryIcon().click();
                break;
            case "Graphic":
                StoryCreationPage.addGraphicIcon().click();
                break;
            case "Video":
                StoryCreationPage.addVideoIcon().click();
                break;
            case "Audio":
                StoryCreationPage.addAudioIcon().click();
                break;
        }
    }

    @Then("^I click Save Story bottom$")
    public void iClickSaveStoryBottom() throws Throwable {
        StoryCreationPage.saveBtnBottom().click();
    }

    @Then("^I click Save Story top link$")
    public void iClickSaveStoryTop() throws Throwable {
        StoryCreationPage.saveLinkTop().click();
    }

    @Then("^I click (SAVE|SAVE & NEXT|CANCEL) bottom button$")
    public void iClickSAVENEXTCANCELBottomButton(String buttonName) throws Throwable {
        switch (buttonName){
            case "SAVE":
                StoryCreationPage.saveBtnBottom();
                break;
            case "SAVE & NEXT":
                StoryCreationPage.saveAndNextBtnBottom().click();
                break;
            case "Cancel":
                StoryCreationPage.cancelBtnBottom().click();
                break;
        }
    }

    @And("^I delete first Text article at Tasks Panel$")
    public void iDeleteFirstTextArticleAtTasksPanel() throws Throwable {
        StoryCreationPageActions.deleteArticle(StoryCreationPage.TasksPanel.textArticleLabel());
    }
}
