package pageAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.desktop.ControlPanel;
import pageObject.mobile.mControlPanel;
import testRunner.TestRunner;
import webDriver.Driver;

import java.util.List;

public class BasePageActions {
    protected static WebDriver driver = Driver.getCurrentDriver();
    static int sleepTimeout = Integer.parseInt(TestRunner.config.get("msSleep"));
    protected static WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(TestRunner.config.get("wdWait")));
    protected static Actions action = new Actions(driver);

    public static String getControlHeaderName() {
        if (TestRunner.isMobile) {
            return mControlPanel.controlHeader().getText();
        } else {
            return ControlPanel.controlHeader().getText();
        }
    }

    public static void waitForPageLoadingIsCompleted() throws InterruptedException {
        if (TestRunner.isMobile) {
            sleep();
        } else {
            wait.until(ExpectedConditions.attributeContains(By.id("page-is-fully-loaded"), "value", "true"));
            sleep();
        }
    }

    public static WebElement findElementWithText(String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

    protected static void scrollToElement(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
    }

    protected static void sleep() throws InterruptedException {
        Thread.sleep(sleepTimeout);
    }

    protected static void expandAll(List<WebElement> elementsToExpand) {
        for (WebElement ele : elementsToExpand) {
            ele.click();
        }
    }

    protected static void collapseAll(List<WebElement> elementsToCollapse) {
        for (WebElement ele : elementsToCollapse) {
            ele.click();
        }
    }

    public static void callContextMenuForElement(WebElement ele) {
        action.moveToElement(ele).perform();
    }
}
