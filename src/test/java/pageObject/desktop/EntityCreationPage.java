package pageObject.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.util.List;

public class EntityCreationPage {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement treatEventCreationPage() {
        return driver.findElement(By.xpath("//div[@class='headTitle']/span[contains(text(),'Event') or contains(text(),'Story')]"));
    }

    public static WebElement uploadingMessage() {
        return driver.findElement(By.xpath("//div[@class='loadingMsg' and text()='Saving data...']"));
    }

    public static class generalPanel {
        public static WebElement descriptionText() {
            return driver.findElement(By.xpath("//div[contains(@class,'element-title')]//span/*"));
        }

        public static WebElement description() {
            return driver.findElement(By.xpath("//div[contains(@class,'element-title')]//textarea"));
        }

        public static WebElement notePanelText() {
            return driver.findElement(By.xpath("//div[contains(@class,'note-panel')]//span/*"));
        }

        public static WebElement notePanel() {
            return driver.findElement(By.xpath("//div[contains(@class,'note-panel')]//textarea"));
        }

        public static WebElement uploadPanel() {
            return driver.findElement(By.xpath("//div[@class='attachments']//input[@class='gwt-FileUpload']"));
        }

        public static WebElement attachment(String fileName){
            return driver.findElement(By.xpath("//a[@class='document-name' and text()='" + fileName + "']"));
        }

        public static WebElement locationAddBtn() {
            return driver.findElement(By.xpath("//div[text()='Location']/following::a[text()='Add']"));
        }

        public static WebElement locationInput() {
            return driver.findElement(By.xpath("//div[@class='location-edit']//input[not(contains(@style,'hidden'))]"));
        }

        public static WebElement locationText() {
            return driver.findElement(By.xpath("//div[@class='location-name']/span"));
        }

        public static WebElement associatedWithLink() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]/div/div"));
        }

        public static WebElement associatedWithPopup() {
            return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//div[@class='popupContent']"));
        }

        public static class AssociatedWithPopup{
            public static WebElement mainCheckbox(){
                return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//a[contains(@class,'aCheckBox')]"));
            }

            public static List<WebElement> expandIcons() {
                return driver.findElements(By.xpath("//div[contains(@class,'groups-filter')]//div[@title='Expand']"));
            }

            public static List<WebElement> collapseIcons() {
                return driver.findElements(By.xpath("//div[contains(@class,'groups-filter')]//div[@title='Collapse']"));
            }

            public static WebElement groupLabel(String groupName) {
                return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//*[text()='" + groupName + "']"));
            }

            public static WebElement enterBtn() {
                return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//a[text()='Enter']"));
            }

            public static WebElement cancelBtn() {
                return driver.findElement(By.xpath("//div[contains(@class,'groups-filter')]//a[text()='Cancel']"));
            }
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
    }

    public static class ContextMenu {
        public static WebElement popup() {
            return driver.findElement(By.xpath("//div[@class='popupContent']"));
        }

        public static WebElement open() {
            return driver.findElement(By.xpath("//div[@class='popupContent']//a[text()='Open']"));
        }

        public static WebElement delete() {
            return driver.findElement(By.xpath("//div[@class='popupContent']//a[text()='Delete']"));
        }
    }

    public static class ConfirmationDialog {
        public static WebElement YES() {
            return driver.findElement(By.xpath("//div[@class='popupContent']//a[text()='Yes']"));
        }

        public static WebElement NO() {
            return driver.findElement(By.xpath("//div[@class='popupContent']//a[text()='No']"));
        }

        public static WebElement title() {
            return driver.findElement(By.xpath("//div[@class='dialog-title']/span"));
        }

        public static WebElement body() {
            return driver.findElement(By.xpath("//tr[@class='fields-table-row']//div"));
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