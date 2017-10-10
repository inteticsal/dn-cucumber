package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.EntityCreation;
import pageAction.desktop.NavPanel;

public class EntitySteps {
    @And("^I am at new Entity creation page$")
    public void iAmAtNewEntityCreationPage() {
        EntityCreation.verifyPageIsActive();
    }

    @And("^I enter Entity Description \"([^\"]*)\"$")
    public void iEnterEntityDescription(String text) {
        EntityCreation.Description.set(text);
    }

    @And("^I add (Text|Photo|Photo Gallery|Graphic|Video|Audio|Live) task to Entity$")
    public void iAddEntityToEvent(String eventTaskName) {
        EntityCreation.Task.add(eventTaskName);
    }

    @Then("^I add \"([^\"]*)\" platform to Entity$")
    public void iAddPlatformToEntity(String eventPlatformName) {
        EntityCreation.Platform.add(eventPlatformName);
    }

    @Then("^I set platform category to \"([^\"]*)\"$")
    public void iSetPlatformCategoryTo(String eventCategoryName) {
        EntityCreation.Platform.setCategory(eventCategoryName);
    }

    @And("^I set publication date to \"([^\"]*)\"$")
    public void iSetPublicationDateTo(String eventPubDate) {
        EntityCreation.Platform.setPublicationDate(eventPubDate);
    }

    @Then("^I click Save Entity top link$")
    public void iClickSaveEntityTopLink() {
        EntityCreation.clickSaveTopLink();
    }

    @Then("^I click Save Story bottom$")
    public void iClickSaveStoryBottom() {
        EntityCreation.clickSaveBtn();
    }

    @Then("^I click (SAVE|SAVE & NEXT|CANCEL) bottom button$")
    public void iClickSAVENEXTCANCELBottomButton(String btnLabel) {
        switch (btnLabel) {
            case "SAVE":
                EntityCreation.clickSaveBtn();
                break;
            case "SAVE & NEXT":
                EntityCreation.clickSaveAndNextBtn();
                break;
            case "Cancel":
                EntityCreation.clickCancelBtn();
                break;
        }
    }

    @Then("^I create a pure event$")
    public void iCreateAPureEvent() {
        NavPanel.createNewItem("Event");
        //TODO:
    }

    @And("^I upload PNG image$")
    public void iUploadImage() {
        EntityCreation.Attachments.uploadImage();
    }

    @And("^I enter note with \"([^\"]*)\" text$")
    public void iEnterNoteWithText(String text) throws Throwable {
        EntityCreation.Note.set(text);
    }

    @And("^I set location to \"([^\"]*)\"$")
    public void iSetLocationTo(String locationName) throws Throwable {
        EntityCreation.Location.set(locationName);
    }

    @And("^I associate it with \"([^\"]*)\"$")
    public void iAssociateItWith(String groupLabel) throws Throwable {
        EntityCreation.Group.associateWith(groupLabel);
    }

    @And("^I verify Entity Description \"([^\"]*)\"$")
    public void iVerifyEntityDesctiption(String text) throws Throwable {
        EntityCreation.Description.verify(text);
    }

    @And("^I clear Entity Description$")
    public void iClearEntityDescription() throws Throwable {
        EntityCreation.Description.clear();
    }

    @And("^I delete first Text article at Tasks Panel$")
    public void iDeleteFirstTextArticleAtTasksPanel() throws Throwable {
        EntityCreation.Article.deleteFirst();
    }
}