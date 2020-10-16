package stepdefinition;

import base.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IandAHomePageMain;
import pages.IandALoginPageMain;

public class IandALoginSteps extends PageObjectManager<IandALoginSteps> {

    protected IandALoginPageMain aiLogin;
    protected IandAHomePageMain aiHome;

    @Given("User is on I&A Login Page")
    public void navigateToSimplifyLoginPage() {
        openBrowser("chrome");
        aiLogin = new IandALoginPageMain();
        aiLogin.openIandALoginPage();
        aiLogin.clickAcceptCookiesBtn();
    }

    @When("User enters a valid alvaro@gsmtest.com and Pa$$w0rd")
    public void completeLoginDetails() {
        aiLogin.populateEmailAddress("alvaro@gsmtest.com");
        aiLogin.populatePassword("Pa$$w0rd1");
        System.out.println("Populating username and password");
    }

    @When("User clicks on login button")
    public void clicksOnLoginButton() {
        aiLogin.clickLoginBtn();
        System.out.println("Clicking Login button");
    }

    @Then("User is redirected to the Home page")
    public void verifyRedirectionToHomePage() {
        aiHome = new IandAHomePageMain();
        aiHome.verifyGroupTitleHeading();
        aiHome.verifyIandAHomePageUrl();
        closeBrowser();
    }

}
