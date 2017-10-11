package pageAction.desktop;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.desktop.LoginPage;
import testRunner.TestRunner;

public class Login extends BasePageActions {
    public static void login(String userName) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginBtn()));
        LoginPage.inputEmail().sendKeys(userName);
        LoginPage.inputPassword().sendKeys(TestRunner.users.get(userName));
        LoginPage.loginBtn().click();
    }

    public static void verifyPageIsActive() {
        LoginPage.treatLoginPageElement().isDisplayed();
    }
}