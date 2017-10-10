package pageAction.desktop;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.desktop.LoginPage;

public class Login extends BasePageActions {
    public static void login(String mail, String pwd) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginBtn()));
        LoginPage.inputEmail().sendKeys(mail);
        LoginPage.inputPassword().sendKeys(pwd);
        LoginPage.loginBtn().click();
    }

    public static void verifyPageIsActive() {
        LoginPage.treatLoginPageElement().isDisplayed();

    }
}