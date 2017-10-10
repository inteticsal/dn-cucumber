package pageObject.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

public class NavigationPanel {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement menuHamburger() {
        return driver.findElement(By.xpath("//a[@class='menu-hamburger']"));
    }

    public static WebElement menuHamburgerPopUp() {
        return driver.findElement(By.xpath("//div[@class='popup-menu hamburger-popup']"));
    }

    public static WebElement itemHamburgerPopUp(String hamburgerItem) {
        return driver.findElement(By.xpath("//div[@class='popup-menu hamburger-popup']/*[text()='" + hamburgerItem + "']"));
    }

    public static WebElement logoutBtn() {
        return driver.findElement(By.xpath("//*[@id='logoutId']"));
    }

    public static WebElement selectedMenuItem() {
        return driver.findElement(By.xpath("//*[@class='gwt-Anchor menu-item main-menu-selected']"));
    }

    public static WebElement callItemsToCreatePopUp() {
        return driver.findElement(By.xpath("//a[@class='select-item']"));
    }

    public static WebElement selectItemToCreatePopUp(String itemToCreate) {
        return driver.findElement(By.xpath("//div[@class='popupContent']//div[@class='gwt-Label' and text()='" + itemToCreate + "']"));
    }

    public static WebElement mainMenuNavigationItem(String itemName) {
        return driver.findElement(By.xpath("//div[@class='main-menu']/a[text()='" + itemName + "']"));
    }

    public static WebElement secondaryMenuNavigationItem(String itemName) {
        return driver.findElement(By.xpath("//div[@class='popup-menu secondary-menu']/a[text()='" + itemName + "']"));
    }

    public static WebElement navigationMenuItem(String itemHref) {
        return driver.findElement(By.xpath("//a[@href='" + itemHref + "']"));
    }

    public static WebElement imageLogo() {
        return driver.findElement(By.xpath("//img[@src='images/desknet_logo.png']"));
    }

    public static WebElement searchIcon() {
        return driver.findElement(By.xpath("//div[@id='searchId']"));
    }

    public static WebElement advancedSearchLink() {
        return driver.findElement(By.xpath("//a[@class='advancedSearchLink']"));
    }

}