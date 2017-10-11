package pageAction.mobile;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pageAction.BasePageActions;
import pageObject.mobile.mLoginPage;
import testRunner.TestRunner;

public class mLoginActions extends BasePageActions {
    public static void login(String userName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(mLoginPage.loginBtn()));
        mLoginPage.inputEmail().sendKeys(userName);
        mLoginPage.inputPassword().sendKeys(TestRunner.users.get(userName));
        mLoginPage.loginBtn().click();
        waitForPageLoadingIsCompleted();
    }

    public static void verifyPageIsActive() {
        mLoginPage.treatLoginPageElement().isDisplayed();
    }
}