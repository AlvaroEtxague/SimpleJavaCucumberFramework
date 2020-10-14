package stepdefinition;

import base.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UnsplashPageMain;

public class UnsplashHomeSteps extends PageObjectManager<UnsplashHomeSteps> {

    protected UnsplashPageMain unsplashHome;

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        openBrowser("Chrome");
        unsplashHome = new UnsplashPageMain();
        unsplashHome.openUnsplashHome();
    }

    @When("User clicks Architecture link")
    public void user_clicks_architecture_link() {
        System.out.println("I'm in the WHEN method");
    }

    @Then("User is redirected to Architecture page")
    public void user_is_redirected_to_architecture_page() {
        unsplashHome.clickArchitectureLink();
        closeBrowser();
    }
}
