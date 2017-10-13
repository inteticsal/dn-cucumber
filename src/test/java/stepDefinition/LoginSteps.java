package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageAction.desktop.Login;
import pageAction.desktop.NavPanel;
import pageAction.mobile.mLoginActions;
import pageObject.desktop.NavigationPanel;
import testRunner.TestRunner;

public class LoginSteps {
    @When("^I login as valid user$")
    public void iLoginAsValidUser() throws Throwable {
        if (TestRunner.isMobile) {
            mLoginActions.login("org1");
        } else {
            Login.login("org1");
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

    @Then("^I login as \"([^\"]*)\" user$")
    public void iLoginAsUser(String name) throws Throwable {
        if (TestRunner.isMobile) {
            mLoginActions.login(name);
        } else {
            Login.login(name);
        }
    }

    @And("^I log out$")
    public void iLogOut() throws Throwable {
        NavPanel.logout();
    }
}
