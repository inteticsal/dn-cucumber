package pageAction.desktop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.desktop.EventCreationPage;
import webDriver.Driver;

public class EventCreationPageActions extends BasePageActions {

    public static void callContextMenuForElement(WebElement ele) {
        action.moveToElement(ele).perform();
    }

    public static void verifyPageIsActive() {
        EventCreationPage.treatEventCreationPage().isDisplayed();
    }

    public static void setDescription(String description) {
        EventCreationPage.generalBlock.descriptionTextArea().sendKeys(Driver.timeStamp + "-" + description);
        EventCreationPage.treatEventCreationPage().click();
    }

    public static void clearDescription() throws InterruptedException {
        EventCreationPage.generalBlock.currentDescriptionText().click();
        EventCreationPage.generalBlock.descriptionTextArea().clear();
    }

    public static String getDescription() {
        return EventCreationPage.generalBlock.currentDescriptionText().getText();
    }

    public static void verifyDescription(String expectedDescription) {
        Assert.assertEquals(getDescription(), Driver.timeStamp + "-" + expectedDescription);
    }

    public static void setNote(String textNote) {
        EventCreationPage.generalBlock.notePanel().click();
        EventCreationPage.generalBlock.notePanel().sendKeys(textNote);
    }

    public static void deleteArticle(WebElement ele) {
        callContextMenuForElement(ele);
        EventCreationPage.TasksPanel.deleteLinkContextMenu().click();
    }

    public static void uploadImage() {
        EventCreationPage.generalBlock.uploadPanel().sendKeys(System.getProperty("user.dir") + "/src/test/testData/desk-net.png");
    }

    public static void setLocation(String locationName) throws InterruptedException {
        sleep();
        EventCreationPage.generalBlock.locationPanelLink().click();
        EventCreationPage.generalBlock.locationPanelInput().sendKeys(locationName);
    }

    public static void associateWith(String groupName) {
        EventCreationPage.generalBlock.associatedWithLink().click();
        expandAll(EventCreationPage.generalBlock.associatedWithPopupExpandIcons());
        EventCreationPage.generalBlock.associatedWithPopupGroupLabel(groupName).click();
        EventCreationPage.generalBlock.associatedWithPopupEnterBtn().click();
    }

    public static void setPlatformCategory(String categoryName) {
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

    public static void addTask(String taskName) {
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

    public static void addPlatform(String platformName) {
        EventCreationPage.PlatformsPanel.addPlatform(platformName).click();
    }

    public static void clickSaveTopLink() {
        EventCreationPage.saveLinkTop().click();
    }
}