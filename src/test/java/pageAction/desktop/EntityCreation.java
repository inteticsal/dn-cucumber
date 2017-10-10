package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.desktop.EntityCreationPage;
import webDriver.Driver;

public class EntityCreation extends BasePageActions {

    public static void verifyPageIsActive() {
        EntityCreationPage.treatEventCreationPage().isDisplayed();
    }

    public static void clickSaveTopLink() {
        EntityCreationPage.saveLinkTop().click();
    }

    public static void clickSaveBtn() {
        EntityCreationPage.saveBtnBottom().click();
    }

    public static void clickSaveAndNextBtn() {
        EntityCreationPage.saveAndNextBtnBottom().click();
    }

    public static void clickCancelBtn() {
        EntityCreationPage.cancelBtnBottom().click();
    }

    public static class Description {
        public static void set(String description) {
            EntityCreationPage.generalPanel.descriptionTextArea().sendKeys(Driver.timeStamp + "-" + description);
            EntityCreationPage.treatEventCreationPage().click();
        }

        public static void clear() throws InterruptedException {
            EntityCreationPage.generalPanel.currentDescriptionText().click();
            EntityCreationPage.generalPanel.descriptionTextArea().clear();
        }

        public static String get() {
            return EntityCreationPage.generalPanel.currentDescriptionText().getText();
        }

        public static void verify(String expectedDescription) {
            Assert.assertEquals(get(), Driver.timeStamp + "-" + expectedDescription);
        }
    }

    public static class Note {
        public static void set(String textNote) {
            EntityCreationPage.generalPanel.notePanel().click();
            EntityCreationPage.generalPanel.notePanel().sendKeys(textNote);
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
            EntityCreationPage.TasksPanel.deleteLinkContextMenu().click();
        }

        public static void deleteFirst() {
            WebElement element = EntityCreationPage.TasksPanel.textArticleLabel();
            callContextMenuForElement(element);
            EntityCreationPage.TasksPanel.deleteLinkContextMenu().click();
        }
    }

    public static class Attachments {
        public static void uploadImage() {
            EntityCreationPage.generalPanel.uploadPanel().sendKeys(System.getProperty("user.dir") + "/src/test/testData/desk-net.png");
        }
    }

    public static class Location {
        public static void set(String locationName) throws InterruptedException {
            sleep();
            EntityCreationPage.generalPanel.locationPanelLink().click();
            EntityCreationPage.generalPanel.locationPanelInput().sendKeys(locationName);
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
            EntityCreationPage.generalPanel.associatedWithLink().click();
            expandAll(EntityCreationPage.generalPanel.associatedWithPopupExpandIcons());
            EntityCreationPage.generalPanel.associatedWithPopupGroupLabel(groupName).click();
            EntityCreationPage.generalPanel.associatedWithPopupEnterBtn().click();
        }
    }

    public static class Platform {
        public static void add(String platformName) {
            EntityCreationPage.PlatformsPanel.addPlatform(platformName).click();
        }

        public static void setCategory(String categoryName) {
            //TODO: verify if required platform is already selected
            wait.until(ExpectedConditions.elementToBeClickable(EntityCreationPage.PlatformsPanel.selectCategory()));
            EntityCreationPage.PlatformsPanel.selectCategory().click();
            wait.until(ExpectedConditions.visibilityOf(EntityCreationPage.PlatformsPanel.selectCategoryPopUp(categoryName)));
            EntityCreationPage.PlatformsPanel.selectCategoryPopUp(categoryName).click();
        }

        public static void setPublicationDate(String pubDate) {
            EntityCreationPage.PlatformsPanel.publicationDate().click();
            EntityCreationPage.PlatformsPanel.publicationDatePopUp(pubDate).click();
        }
    }

    public static class Task {
        public static void add(String taskName) {
            switch (taskName) {
                case "Text":
                    EntityCreationPage.TasksPanel.addTextIcon().click();
                    break;
                case "Photo":
                    EntityCreationPage.TasksPanel.addPhotoIcon().click();
                    break;
                case "Photo Gallery":
                    EntityCreationPage.TasksPanel.addPhotoGalleryIcon().click();
                    break;
                case "Graphic":
                    EntityCreationPage.TasksPanel.addGraphicIcon().click();
                    break;
                case "Video":
                    EntityCreationPage.TasksPanel.addVideoIcon().click();
                    break;
                case "Audio":
                    EntityCreationPage.TasksPanel.addAudioIcon().click();
                    break;
                case "Live":
                    EntityCreationPage.TasksPanel.allTasksBtn().click();
                    EntityCreationPage.TasksPanel.allTasksElementPopUp("Live").click();
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