package pages;

import base.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IandALoginPageMain extends PageObjectManager<IandALoginPageMain> implements IandALoginModel {

    //WEBELEMENTS
    private String loginPageURL = "https://api-test.allianz.com/ourhealth/2/login";

    @FindBy(css = "#allianzLogo")
    private WebElement loginPageLogo;

    @FindBy(id = "email")
    private WebElement loginEmailAddress;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "forgotPasswordLink")
    private WebElement forgotPasswordLink;

    @FindBy(css = ".optanon-allow-all.accept-cookies-button")
    private WebElement cookiesAcceptButton;

    //GETTERS
    @Override
    public String getIandALoginURL() {
        return loginPageURL;
    }

    @Override
    public WebElement getLoginPageLogo() {
        return loginPageLogo;
    }

    @Override
    public WebElement getLoginEmailAddress() {
        return loginEmailAddress;
    }

    @Override
    public WebElement getLoginPassword() {
        return loginPassword;
    }

    @Override
    public WebElement getLoginButton() {
        return loginButton;
    }

    @Override
    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    @Override
    public WebElement getCookiesAcceptButton() {
        return cookiesAcceptButton;
    }

    //PAGE INTERACTIONS
    public void verifyLogoIsDisplayed() {
        gens.waitForElement(getLoginPageLogo(), defaultTimeout);
        Assert.assertTrue(gens.existsElement(getLoginPageLogo()));
        System.out.println("Login Page Logo is displayed");
    }

    public void populateEmailAddress(String emailAddress) {
        gens.type(emailAddress, loginEmailAddress);
        System.out.println("Email entered: " + emailAddress);
    }

    public void populatePassword(String password) {
        gens.type(password, loginPassword);
        System.out.println("Password entered: " + password);
    }

    public void clickLoginBtn(){
        gens.click(getLoginButton());
        System.out.println("Clicking I&A Login button");
    }

    public void populateLoginDetails(String emailAddress, String password){
        populateEmailAddress(emailAddress);
        populatePassword(password);
        clickLoginBtn();
        System.out.println("User Log In");
    }

    public void clickForgotPasswordLink(){
        gens.waitForElement(getForgotPasswordLink(), defaultTimeout);
        gens.click(getForgotPasswordLink());
        System.out.println("Clicking Reset Password Link");
    }

    public void verifyForgotPasswordLink(){
        gens.waitForElement(getForgotPasswordLink(), defaultTimeout);
        String expected = "https://api-test.allianz.com/myhealth/2/forgot/password";
        String link = getForgotPasswordLink().getAttribute("href");
        gens.compareStrings(link, expected);
        System.out.println("Verifying Forgot Password Link");
    }

    public void openIandALoginPage(){
        gens.getURL(getIandALoginURL());
        System.out.println("Navigating to " + getIandALoginURL().toString());
    }

    public void clickAcceptCookiesBtn(){
        gens.waitForElement(getCookiesAcceptButton(), defaultTimeout);
        gens.click(getCookiesAcceptButton());
        System.out.println("Clicking Accept Cookies button");
    }
}
