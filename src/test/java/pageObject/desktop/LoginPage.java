package pageObject.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testRunner.TestRunner;
import webDriver.Driver;

public class LoginPage {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement treatLoginPageElement() {
        if (TestRunner.isMobile) {
            return driver.findElement(By.xpath("//div[text()='LOGIN']"));
        }
        return driver.findElement(By.xpath("//a[@id='login-button']"));
    }

    public static WebElement inputEmail() {
        if (TestRunner.isMobile) {
            return driver.findElement(By.xpath("//input[@name='j_username']"));
        }
        return driver.findElement(By.id("username"));
    }

    public static WebElement inputPassword() {
        if (TestRunner.isMobile) {
            return driver.findElement(By.xpath("//input[@name='j_password']"));
        }
        return driver.findElement(By.id("password"));
    }

    public static WebElement loginBtn() {
        if (TestRunner.isMobile) {
            return driver.findElement(By.xpath("//div[text()='LOGIN']"));
        }
        return driver.findElement(By.id("login-button"));
    }
}
