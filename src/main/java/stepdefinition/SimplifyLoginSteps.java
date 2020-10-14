package stepdefinition;

import base.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SimplifyCommercePageMain;

public class SimplifyLoginSteps extends PageObjectManager<SimplifyLoginSteps> {

    protected SimplifyCommercePageMain simplifyLogin;

    @Given("User is on Login Page")
    public void navigateToSimplifyLoginPage() {
        openBrowser("chrome");
        simplifyLogin = new SimplifyCommercePageMain();
        simplifyLogin.openSimplifyLogin();
    }

    @When("User enters a valid validUser and validPass123")
    public void populateUserLoginDetails() {
//        simplifyLogin.populateEmailAddress(validUser);
//        simplifyLogin.populatePassword(validPass123);
        System.out.println("Populating username and password");
    }

    @Then("User can click on login button")
    public void clicks_on_login_button() {
//        simplifyLogin.clickLoginBtn();
        System.out.println("Clicking Login button");
        closeBrowser();
    }

}
