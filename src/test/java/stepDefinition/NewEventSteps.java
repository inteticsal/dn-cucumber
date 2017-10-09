package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.EventCreationPageActions;
import pageAction.desktop.NavPanelActions;

public class NewEventSteps {
    @And("^I am at new Event creation page$")
    public void iAmAtNewEventCreationPage() {
        EventCreationPageActions.verifyPageIsActive();
    }

    @And("^I enter Event Description \"([^\"]*)\"$")
    public void iEnterEventDescription(String text) {
        EventCreationPageActions.setDescription(text);
    }

    @And("^I add (Text|Photo|Photo Gallery|Graphic|Video|Audio|Live) task to Event$")
    public void iAddTaskToEvent(String eventTaskName) {
        EventCreationPageActions.addTask(eventTaskName);
    }

    @Then("^I add \"([^\"]*)\" platform to Event$")
    public void iAddPlatformToEvent(String eventPlatformName) {
        EventCreationPageActions.addPlatform(eventPlatformName);
    }

    @Then("^I set platform category to \"([^\"]*)\"$")
    public void iSetPlatformCategoryTo(String eventCategoryName) {
        EventCreationPageActions.setPlatformCategory(eventCategoryName);
    }

    @And("^I set publication date to \"([^\"]*)\"$")
    public void iSetPublicationDateTo(String eventPubDate) {
        EventCreationPageActions.setPublicationDate(eventPubDate);
    }

    @Then("^I click Save Event top link$")
    public void iClickSaveEventTopLink() {
        EventCreationPageActions.clickSaveTopLink();
    }

    @Then("^I create a pure event$")
    public void iCreateAPureEvent() {
        NavPanelActions.createNewItem("Event");
        //TODO:
    }

    @And("^I upload PNG image$")
    public void iUploadImage() {
        EventCreationPageActions.uploadImage();
    }

    @And("^I enter note with \"([^\"]*)\" text$")
    public void iEnterNoteWithText(String text) throws Throwable {
        EventCreationPageActions.setNote(text);
    }

    @And("^I set location to \"([^\"]*)\"$")
    public void iSetLocationTo(String locationName) throws Throwable {
        EventCreationPageActions.setLocation(locationName);
    }

    @And("^I associate it with \"([^\"]*)\"$")
    public void iAssociateItWith(String groupLabel) throws Throwable {
        EventCreationPageActions.associateWith(groupLabel);
    }

    @And("^I verify Event Description \"([^\"]*)\"$")
    public void iVerifyEventDesctiption(String text) throws Throwable {
        EventCreationPageActions.verifyDescription(text);
    }

    @And("^I clear Event Description$")
    public void iClearEventDescription() throws Throwable {
        EventCreationPageActions.clearDescription();
    }
}