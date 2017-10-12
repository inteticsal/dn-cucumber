package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
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

    protected static void changeFocus() {
        EntityCreationPage.treatEventCreationPage().click();
    }

    public static class Description {
        public static void set(String description) {
            try {
                EntityCreationPage.generalPanel.descriptionText().click();
            } catch (WebDriverException ElementNotVisibleException) {
            }
            EntityCreationPage.generalPanel.description().sendKeys(Driver.timeStamp + "-" + description);
            changeFocus();
        }

        public static void clear() throws InterruptedException {
            EntityCreationPage.generalPanel.descriptionText().click();
            EntityCreationPage.generalPanel.description().clear();
            changeFocus();
        }

        public static String currentValue() {
            return EntityCreationPage.generalPanel.descriptionText().getText();
        }

        public static void verify(String expectedDescription) {
            Assert.assertEquals(currentValue(), Driver.timeStamp + "-" + expectedDescription);
        }
    }

    public static class Note {
        public static void set(String textNote) {
            EntityCreationPage.generalPanel.notePanelText().click();
            EntityCreationPage.generalPanel.notePanel().sendKeys(textNote);
            changeFocus();
        }

        public static void clear() {
            EntityCreationPage.generalPanel.notePanelText().click();
            EntityCreationPage.generalPanel.notePanel().clear();
            changeFocus();
        }

        public static String currentValue() {
            return EntityCreationPage.generalPanel.notePanelText().getText();
        }

        public static void verify(String expectedNote) {
            Assert.assertEquals(currentValue(), expectedNote);
        }
    }

    public static class Article {
        public static void delete(WebElement ele) {
            callContextMenuForElement(ele);
            EntityCreationPage.ContextMenu.delete().click();
        }

        public static void deleteFirst() {
            WebElement element = EntityCreationPage.TasksPanel.textArticleLabel();
            callContextMenuForElement(element);
            EntityCreationPage.ContextMenu.delete().click();
        }
    }

    public static class Attachments {
        public static void uploadImage(String fileName) {
            //TODO: add verification if file exists in testData
            EntityCreationPage.generalPanel.uploadPanel().sendKeys(System.getProperty("user.dir") + "/src/test/testData/" + fileName);
            try {
                wait.until(ExpectedConditions.invisibilityOf(EntityCreationPage.uploadingMessage()));
            } catch (WebDriverException NoSuchElementException) {
            }
        }

        public static void verify(String fileName) {
            EntityCreationPage.generalPanel.attachment(fileName).isDisplayed();
        }

        public static void remove(String fileName) {
            callContextMenuForElement(EntityCreationPage.generalPanel.attachment(fileName));
            EntityCreationPage.ContextMenu.delete().click();
        }
    }

    public static class ConfirmationDialog {
        public static void clickYes() {
            EntityCreationPage.ConfirmationDialog.YES().click();
        }

        public static void clickNo() {
            EntityCreationPage.ConfirmationDialog.NO().click();
        }

        public static void verifyTitle(String expectedText) {
            Assert.assertEquals(expectedText, getCurrentTitle());
        }

        public static void verifyBody(String expectedText) {
            Assert.assertEquals(expectedText, getCurrentBody());
        }

        public static String getCurrentTitle() {
            return EntityCreationPage.ConfirmationDialog.title().getText();
        }

        public static String getCurrentBody() {
            return EntityCreationPage.ConfirmationDialog.body().getText();
        }
    }

    public static class Location {
        public static void set(String locationName) throws InterruptedException {
            EntityCreationPage.generalPanel.locationAddBtn().click();
            EntityCreationPage.generalPanel.locationInput().sendKeys(locationName);
            changeFocus();
        }

        public static void remove() {
            EntityCreationPage.generalPanel.locationText().click();
            EntityCreationPage.generalPanel.locationInput().clear();
            changeFocus();
        }

        public static String currentValue() {
            return EntityCreationPage.generalPanel.locationText().getText();
        }

        public static void verify(String expectedLocation) {
            Assert.assertEquals(expectedLocation, currentValue());
        }
    }

    public static class Group {
        public static void uncheckAll() {
            EntityCreationPage.generalPanel.associatedWithLink().click();
            uncheckElement(EntityCreationPage.generalPanel.AssociatedWithPopup.mainCheckbox());
            EntityCreationPage.generalPanel.AssociatedWithPopup.enterBtn().click();
        }

        public static void checkAll() {
            EntityCreationPage.generalPanel.associatedWithLink().click();
            uncheckElement(EntityCreationPage.generalPanel.AssociatedWithPopup.mainCheckbox());
            EntityCreationPage.generalPanel.AssociatedWithPopup.mainCheckbox().click();
            EntityCreationPage.generalPanel.AssociatedWithPopup.enterBtn().click();
        }

        public static void associateWith(String groupName) {
            EntityCreationPage.generalPanel.associatedWithLink().click();
            expandAll(EntityCreationPage.generalPanel.AssociatedWithPopup.expandIcons());
            EntityCreationPage.generalPanel.AssociatedWithPopup.groupLabel(groupName).click();
            EntityCreationPage.generalPanel.AssociatedWithPopup.enterBtn().click();
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