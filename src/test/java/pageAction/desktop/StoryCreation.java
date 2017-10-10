package pageAction.desktop;

import org.openqa.selenium.WebElement;
import pageAction.BasePageActions;
import pageObject.desktop.StoryCreationPage;
import webDriver.Driver;

public class StoryCreation extends BasePageActions {

    public static void verifyPageIsActive() {
        StoryCreationPage.treatStoryCreationPage().isDisplayed();
    }

    public static void setDescription(String description) {
        StoryCreationPage.descriptionTextArea().sendKeys(Driver.timeStamp + "-" + description);
    }

    public static void addTask(String taskName) {
        switch (taskName) {
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

    public static void clickSaveTopLink() {
        StoryCreationPage.saveLinkTop().click();
    }

    public static void clickSaveBtn() {
        StoryCreationPage.saveBtnBottom().click();
    }

    public static void clickSaveAndNextBtn() {
        StoryCreationPage.saveAndNextBtnBottom().click();
    }

    public static void clickCancelBtn() {
        StoryCreationPage.cancelBtnBottom().click();
    }

    public static void deleteFirstTextArticle() {
        WebElement element = StoryCreationPage.TasksPanel.textArticleLabel();
        callContextMenuForElement(element);
        StoryCreationPage.TasksPanel.deleteLinkContextMenu().click();
    }

    public static void callContextMenuForElement(WebElement ele) {
        action.moveToElement(ele).perform();
    }
}
