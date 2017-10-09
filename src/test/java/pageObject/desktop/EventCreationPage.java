package pageObject.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.util.List;

public class EventCreationPage {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement treatEventCreationPage() {
        return driver.findElement(By.xpath("//div[@class='headTitle']/span[contains(text(),'Event')]"));
    }

    public static class generalBlock {
        public static WebElement currentDescriptionText() {
            return driver.findElement(By.xpath("//span[@class='elementTitleContent']/span"));
        }

        public static WebElement descriptionTextArea() {
            return driver.findElement(By.xpath("//div[contains(@class,'element-title')]//textarea"));
        }

        public static WebElement notePanel() {
            return driver.findElement(By.xpath("//div[contains(@class,'note-panel')]"));
        }

        public static WebElement uploadPanel() {
            return driver.findElement(By.xpath("//div[@class='attachments']//input[@class='gwt-FileUpload']"));
        }

        public static WebElement locationPanelLink() {
            return driver.findElement(By.xpath("//div[text()='Location']/following::a[text()='Add']"));
        }

        public static WebElement locationPanelInput() {
            return driver.findElement(By.xpath("//div[@class='location-edit']//input"));
        }

        public static WebElement associatedWithLink() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]/div/div"));
        }

        public static WebElement associatedWithPopup() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//div[@class='popupContent']"));
        }

        public static List<WebElement> associatedWithPopupExpandIcons() {
            return driver.findElements(By.xpath("//div[@title='Expand']"));
        }

        public static List<WebElement> associatedWithPopupCollapseIcons() {
            return driver.findElements(By.xpath("//div[@title='Collapse']"));
        }

        public static WebElement associatedWithPopupGroupLabel(String groupName) {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//*[text()='" + groupName + "']"));
        }

        public static WebElement associatedWithPopupEnterBtn() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//a[text()='Enter']"));
        }

        public static WebElement associatedWithPopupCancelBtn() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//a[text()='Cancel']"));
        }
    }

    public static class TasksPanel {
        public static WebElement addTextIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[1]"));
        }

        public static WebElement addPhotoIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[2]"));
        }

        public static WebElement addPhotoGalleryIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[3]"));
        }

        public static WebElement addGraphicIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[4]"));
        }

        public static WebElement addVideoIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[5]"));
        }

        public static WebElement addAudioIcon() {
            return driver.findElement(By.xpath("//td[@class='add-publication']/div/div[6]"));
        }

        public static WebElement allTasksBtn() {
            return driver.findElement(By.xpath("//div[@class='newElement']//a[@class='inline-list-box-label' and text()='All']"));
        }

        public static WebElement allTasksElementPopUp(String taskName) {
            return driver.findElement(By.xpath("//div[@class='newElement']//span[text()='" + taskName + "']"));
        }

        public static WebElement textArticleLabel() {
            return driver.findElement(By.xpath("//div[@class='removeBlock']/div[text()='Text']"));
        }

        public static WebElement deleteLinkContextMenu() {
            return driver.findElement(By.xpath("//a[@class='gwt-Anchor' and text()='Delete']"));
        }
    }

    public static class PlatformsPanel {
        public static WebElement addPlatform(String platformName) {
            return driver.findElement(By.xpath("//td[@class='add-publication']//span[text()='" + platformName + "']"));
        }

        public static WebElement selectCategory() {
            return driver.findElement(By.xpath("//div[@class='article publication-block last-panel']//div[@class='page-items']/div[1]/a"));
        }

        public static WebElement selectType() {
            return driver.findElement(By.xpath("//div[@class='article publication-block last-panel']//div[@class='page-items']/div[2]/a"));
        }

        public static WebElement selectTypePopUp(String selectType) {
            return driver.findElement(By.xpath("//div[@class='article publication-block last-panel']//div[@class='list-box-item']//span[text()='" + selectType + "']"));
        }

        public static WebElement selectCategoryPopUp(String selectCategory) {
            return driver.findElement(By.xpath("//div[@class='article publication-block last-panel']//div[@class='list-box-item']//span[text()='" + selectCategory + "']"));
        }

        public static WebElement publicationDate() {
            return driver.findElement(By.xpath("//div[@class='article publication-block last-panel']//div[@class='productionDate']//div[@class='editable-panel-deck']"));
        }

        public static WebElement publicationDatePopUp(String selectDate) {
            return driver.findElement(By.xpath("//div[@class='issue-content-panel']//*[contains(text(),'" + selectDate + "')]"));
        }
    }


    public static WebElement saveLinkTop() {
        return driver.findElement(By.xpath("//div[@class='saveLinks']/a[text()='Save']"));
    }

    public static WebElement cancelLinkTop() {
        return driver.findElement(By.xpath("//div[@class='saveLinks']/a[text()='Cancel']"));
    }

    public static WebElement saveBtnBottom() {
        return driver.findElement(By.xpath("//div[@class='buttons-bottom']/a[text()='Save']"));
    }

    public static WebElement saveAndNextBtnBottom() {
        return driver.findElement(By.xpath("//div[@class='buttons-bottom']/a[text()='Save & Next']"));
    }

    public static WebElement cancelBtnBottom() {
        return driver.findElement(By.xpath("//div[@class='buttons-bottom']/a[text()='Cancel']"));
    }
}