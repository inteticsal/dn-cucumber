package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.desktop.EventCreationPage;
import webDriver.Driver;

public class EventCreation extends BasePageActions {

    public static void callContextMenuForElement(WebElement ele) {
        action.moveToElement(ele).perform();
    }

    public static void verifyPageIsActive() {
        EventCreationPage.treatEventCreationPage().isDisplayed();
    }

    public static void clickSaveTopLink() {
        EventCreationPage.saveLinkTop().click();
    }

    public static class Description {
        public static void set(String description) {
            EventCreationPage.generalPanel.descriptionTextArea().sendKeys(Driver.timeStamp + "-" + description);
            EventCreationPage.treatEventCreationPage().click();
        }

        public static void clear() throws InterruptedException {
            EventCreationPage.generalPanel.currentDescriptionText().click();
            EventCreationPage.generalPanel.descriptionTextArea().clear();
        }

        public static String get() {
            return EventCreationPage.generalPanel.currentDescriptionText().getText();
        }

        public static void verify(String expectedDescription) {
            Assert.assertEquals(get(), Driver.timeStamp + "-" + expectedDescription);
        }
    }

    public static class Note {
        public static void set(String textNote) {
            EventCreationPage.generalPanel.notePanel().click();
            EventCreationPage.generalPanel.notePanel().sendKeys(textNote);
        }

        public static void clear() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void get() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void verify(String expectedNote) {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }
    }

    public static class Article {
        public static void delete(WebElement ele) {
            callContextMenuForElement(ele);
            EventCreationPage.TasksPanel.deleteLinkContextMenu().click();
        }
    }

    public static class Attachments {
        public static void uploadImage() {
            EventCreationPage.generalPanel.uploadPanel().sendKeys(System.getProperty("user.dir") + "/src/test/testData/desk-net.png");
        }
    }

    public static class Location {
        public static void set(String locationName) throws InterruptedException {
            sleep();
            EventCreationPage.generalPanel.locationPanelLink().click();
            EventCreationPage.generalPanel.locationPanelInput().sendKeys(locationName);
        }

        public static void remove() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void get() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void verify(String expectedLocation) {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }
    }

    public static class Group {
        public static void associateWith(String groupName) {
            EventCreationPage.generalPanel.associatedWithLink().click();
            expandAll(EventCreationPage.generalPanel.associatedWithPopupExpandIcons());
            EventCreationPage.generalPanel.associatedWithPopupGroupLabel(groupName).click();
            EventCreationPage.generalPanel.associatedWithPopupEnterBtn().click();
        }
    }

    public static class Platform {
        public static void add(String platformName) {
            EventCreationPage.PlatformsPanel.addPlatform(platformName).click();
        }

        public static void setCategory(String categoryName) {
            //TODO: verify if required platform is already selected
            wait.until(ExpectedConditions.elementToBeClickable(EventCreationPage.PlatformsPanel.selectCategory()));
            EventCreationPage.PlatformsPanel.selectCategory().click();
            wait.until(ExpectedConditions.visibilityOf(EventCreationPage.PlatformsPanel.selectCategoryPopUp(categoryName)));
            EventCreationPage.PlatformsPanel.selectCategoryPopUp(categoryName).click();
        }

        public static void setPublicationDate(String pubDate) {
            EventCreationPage.PlatformsPanel.publicationDate().click();
            EventCreationPage.PlatformsPanel.publicationDatePopUp(pubDate).click();
        }
    }

    public static class Task {
        public static void add(String taskName) {
            switch (taskName) {
                case "Text":
                    EventCreationPage.TasksPanel.addTextIcon().click();
                    break;
                case "Photo":
                    EventCreationPage.TasksPanel.addPhotoIcon().click();
                    break;
                case "Photo Gallery":
                    EventCreationPage.TasksPanel.addPhotoGalleryIcon().click();
                    break;
                case "Graphic":
                    EventCreationPage.TasksPanel.addGraphicIcon().click();
                    break;
                case "Video":
                    EventCreationPage.TasksPanel.addVideoIcon().click();
                    break;
                case "Audio":
                    EventCreationPage.TasksPanel.addAudioIcon().click();
                    break;
                case "Live":
                    EventCreationPage.TasksPanel.allTasksBtn().click();
                    EventCreationPage.TasksPanel.allTasksElementPopUp("Live").click();
                    break;
            }
        }

        public static void remove() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void get() {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }

        public static void verify(String expectedTask) {
            throw new org.apache.commons.lang3.NotImplementedException("Not implemented yet");
        }
    }
}