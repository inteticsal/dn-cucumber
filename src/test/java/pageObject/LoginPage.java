package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

public class LoginPage {
    static WebDriver driver = Driver.getCurrentDriver();

    public static WebElement inputEmail() {
        return driver.findElement(By.id("username"));
    }

    public static WebElement inputPassword() {
        return driver.findElement(By.id("password"));
    }

    public static WebElement loginBtn() {
        return driver.findElement(By.id("login-button"));
    }
}
