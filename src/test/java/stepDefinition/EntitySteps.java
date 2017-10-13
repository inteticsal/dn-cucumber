package stepDefinition;

import cucumber.api.PendingException;
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

    @And("^I enter Entity Note \"([^\"]*)\"$")
    public void iEnterNoteWithText(String text) throws Throwable {
        EntityCreation.Note.set(text);
    }

    @And("^I verify Entity Note \"([^\"]*)\"$")
    public void iVerifyEntityNote(String text) throws Throwable {
        EntityCreation.Note.verify(text);
    }

    @And("^I clear Entity Note$")
    public void iClearEntityNote() throws Throwable {
        EntityCreation.Note.clear();
    }

    @And("^I upload \"([^\"]*)\" to Entity Attachments$")
    public void iUploadImage(String fileName) {
        EntityCreation.Attachments.uploadImage(fileName);
    }

    @And("^I verify Entity Attachment has \"([^\"]*)\"$")
    public void iVerifyEntityAttachment(String fileName) throws Throwable {
        EntityCreation.Attachments.verify(fileName);
    }

    @And("^I delete \"([^\"]*)\" from Entity Attachments$")
    public void iDeleteFromEntityAttachments(String fileName) throws Throwable {
        EntityCreation.Attachments.remove(fileName);
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

    @And("^I click (YES|NO) button at confirmation dialog$")
    public void iClickYESButtonAtConfirmationDialog(String btnName) throws Throwable {
        switch (btnName) {
            case "YES":
                EntityCreation.ConfirmationDialog.clickYes();
                break;
            case "NO":
                EntityCreation.ConfirmationDialog.clickNo();
                break;
        }
    }

    @And("^I see confirmation dialog with (body|title) \"([^\"]*)\"$")
    public void iSeeConfirmationDialogWithTitle(String choise, String text) throws Throwable {
        switch (choise){
            case "body":
                EntityCreation.ConfirmationDialog.verifyBody(text);
                break;
            case "title":
                EntityCreation.ConfirmationDialog.verifyTitle(text);
                break;
        }
    }

    @And("^I set location to \"([^\"]*)\"$")
    public void iSetLocationTo(String locationName) throws Throwable {
        EntityCreation.Location.set(locationName);
    }

    @And("^I verify \"([^\"]*)\" is current Entity Location$")
    public void iVerifyIsCurrentEntityLocation(String text) throws Throwable {
        EntityCreation.Location.verify(text);
    }

    @And("^I remove current Entity Location$")
    public void iRemoveCurrentEntityLocation() throws Throwable {
        EntityCreation.Location.remove();
    }

    @And("^I add \"([^\"]*)\" to Entity Associations$")
    public void iAddToEntityAssociations(String groupLabel) throws Throwable {
        EntityCreation.Group.associateWith(groupLabel);
    }

    @And("^I remove all Entity Associations$")
    public void iRemoveAllEntityAssociations() throws Throwable {
        EntityCreation.Group.uncheckAll();
    }

    @And("^I check all Entity Associations$")
    public void iCheckAllEntityAssociations() throws Throwable {
        EntityCreation.Group.checkAll();
    }

    @And("^I verify Entity Associations is \"([^\"]*)\"$")
    public void iVerifyEntityAssociationsIs(String text) throws Throwable {
        EntityCreation.Group.verify(text);
    }

    @And("^I open Entity Associations popup$")
    public void iCallEntityAssociationsPopup() throws Throwable {
        EntityCreation.Group.openPopup();
    }

    @And("^I click \"([^\"]*)\" in Entity Associations popup$")
    public void iCheckInEntityAssociationsPopup(String checkboxLabel) throws Throwable {
        EntityCreation.Group.clickCheckbox(checkboxLabel);
    }

    @And("^I click (ENTER|CANCEL) in Entity Associations popup$")
    public void iClickENTERInEntityAssociationsPopup(String btnName) throws Throwable {
        switch (btnName){
            case "ENTER":
                EntityCreation.Group.clickEnter();
                break;
            case "CANCEL":
                EntityCreation.Group.clickCancel();
                break;
        }
    }

    @And("^I verify Entity Associations Popup Title is \"([^\"]*)\"$")
    public void iVerifyEntityAssociationsPopupTitleIs(String expectedTitle) throws Throwable {
        EntityCreation.Group.verifyTitlePopup(expectedTitle);
    }

    @And("^I make Entity (Confidential|Not confidential)$")
    public void iMakeItConfidential(String confState) throws Throwable {
        switch (confState) {
            case "Confidential":
                EntityCreation.Confidential.setStatus(true);
                break;
            case "Not confidential":
                EntityCreation.Confidential.setStatus(false);
                break;
        }
    }

    @And("^I set Entity Event (start|end) date to (selected|today) (plus|minus) (\\d+) days$")
    public void iSetEntityEventStartDateToTodayPlusDays(String event, String date, String action, int days) throws Throwable {
        switch (event){
            case "start":
                if (action.equals("plus") && date.equals("selected")) {
                    EntityCreation.Event.increaseSelectedStartDate(days);
                } else if (action.equals("minus")&& date.equals("selected")) {
                    EntityCreation.Event.decreaseSelectedStartDate(days);
                } else if (action.equals("plus") && date.equals("today")) {
                    EntityCreation.Event.increaseTodayStartDate(days);
                } else if (action.equals("minus") && date.equals("today")) {
                EntityCreation.Event.decreaseTodayStartDate(days);
                }
                break;
            case "end":
                if (action.equals("plus") && date.equals("selected")) {
                    EntityCreation.Event.increaseSelectedEndDate(days);
                } else if (action.equals("minus") && date.equals("selected")) {
                    EntityCreation.Event.decreaseSelectedEndDate(days);
                } else if (action.equals("plus") && date.equals("today")) {
                    EntityCreation.Event.increaseTodayEndDate(days);
                } else if (action.equals("minus") && date.equals("today")) {
                    EntityCreation.Event.decreaseTodayEndDate(days);
                }
                break;
        }
    }
}