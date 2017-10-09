package pageObject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

public class mControlPanel {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement controlHeader() {
        return driver.findElement(By.xpath("//div[@class='GA4WLTGDIK']"));
    }

    public static WebElement moreFiltersLink() {
        return driver.findElement(By.xpath("//div[contains(@id,'expand-menu')]//*[local-name() = 'svg'][1][@style='']"));
    }

    public static WebElement hideFiltersLink() {
        return driver.findElement(By.xpath("//div[contains(@id,'expand-menu')]//*[local-name() = 'svg'][2][@style='']"));
    }

    public static WebElement statusFilterDescription() {
        return driver.findElement(By.xpath("//div[text()='Status']/following::div[contains(@class,'comboCaption')][1]"));
    }

    public static WebElement tasksFilterDescription() {
        return driver.findElement(By.xpath("//div[text()='Tasks']/following::div[contains(@class,'comboCaption')][1]"));
    }

    public static WebElement platformsFilterDescription() {
        return driver.findElement(By.xpath("//div[text()='Platforms']/following::div[contains(@class,'comboCaption')][1]"));
    }

    public static WebElement groupsFilterDescription() {
        return driver.findElement(By.xpath("//div[text()='Groups']/following::div[contains(@class,'comboCaption')][1]"));
    }

    public static WebElement checkedFilterParentOption(String optionName) {
        return driver.findElement(By.xpath(""));
    }

    public static WebElement uncheckedFilterParentOption(String optionName) {
        return driver.findElement(By.xpath(""));
    }

    public static WebElement checkedFilterChildOption(String optionName) {
        return driver.findElement(By.xpath(""));
    }

    public static WebElement uncheckedFilterChildOption(String optionName) {
        return driver.findElement(By.xpath(""));
    }

    public static WebElement cancelBtnFilterPopUp() {
        return driver.findElement(By.xpath("//div[contains(@class,'PopupPanel')]//a[text()='Cancel']"));
    }

    public static WebElement enterBtnFilterPopUp() {
        return driver.findElement(By.xpath("//div[contains(@class,'PopupPanel')]//a[text()='Save']"));
    }

    public static WebElement activeFilters() {
        return driver.findElement(By.xpath(""));
    }
}
