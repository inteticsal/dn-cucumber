package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageAction.desktop.Login;
import pageAction.mobile.mLoginActions;
import testRunner.TestRunner;

public class LoginSteps {
    @When("^I login as valid user$")
    public void iLoginAsValidUser() throws Throwable {
        if (TestRunner.isMobile) {
            mLoginActions.login("org1", "tomcattom");
        } else {
            Login.login("org1", "tomcattom");
        }
    }

    @And("^I am at Login page$")
    public void iAmAtLoginPage() throws Throwable {
        if (TestRunner.isMobile) {
            mLoginActions.verifyPageIsActive();
        } else {
            Login.verifyPageIsActive();
        }
    }
}
