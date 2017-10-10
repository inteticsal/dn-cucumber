package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageAction.desktop.EventCreation;
import pageAction.desktop.NavPanel;

public class NewEventSteps {
    @And("^I am at new Event creation page$")
    public void iAmAtNewEventCreationPage() {
        EventCreation.verifyPageIsActive();
    }

    @And("^I enter Event Description \"([^\"]*)\"$")
    public void iEnterEventDescription(String text) {
        EventCreation.Description.set(text);
    }

    @And("^I add (Text|Photo|Photo Gallery|Graphic|Video|Audio|Live) task to Event$")
    public void iAddTaskToEvent(String eventTaskName) {
        EventCreation.Task.add(eventTaskName);
    }

    @Then("^I add \"([^\"]*)\" platform to Event$")
    public void iAddPlatformToEvent(String eventPlatformName) {
        EventCreation.Platform.add(eventPlatformName);
    }

    @Then("^I set platform category to \"([^\"]*)\"$")
    public void iSetPlatformCategoryTo(String eventCategoryName) {
        EventCreation.Platform.setCategory(eventCategoryName);
    }

    @And("^I set publication date to \"([^\"]*)\"$")
    public void iSetPublicationDateTo(String eventPubDate) {
        EventCreation.Platform.setPublicationDate(eventPubDate);
    }

    @Then("^I click Save Event top link$")
    public void iClickSaveEventTopLink() {
        EventCreation.clickSaveTopLink();
    }

    @Then("^I create a pure event$")
    public void iCreateAPureEvent() {
        NavPanel.createNewItem("Event");
        //TODO:
    }

    @And("^I upload PNG image$")
    public void iUploadImage() {
        EventCreation.Attachments.uploadImage();
    }

    @And("^I enter note with \"([^\"]*)\" text$")
    public void iEnterNoteWithText(String text) throws Throwable {
        EventCreation.Note.set(text);
    }

    @And("^I set location to \"([^\"]*)\"$")
    public void iSetLocationTo(String locationName) throws Throwable {
        EventCreation.Location.set(locationName);
    }

    @And("^I associate it with \"([^\"]*)\"$")
    public void iAssociateItWith(String groupLabel) throws Throwable {
        EventCreation.Group.associateWith(groupLabel);
    }

    @And("^I verify Event Description \"([^\"]*)\"$")
    public void iVerifyEventDesctiption(String text) throws Throwable {
        EventCreation.Description.verify(text);
    }

    @And("^I clear Event Description$")
    public void iClearEventDescription() throws Throwable {
        EventCreation.Description.clear();
    }
}