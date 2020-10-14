package pages;

import base.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SimplifyCommercePageMain extends PageObjectManager<SimplifyCommercePageMain> implements SimplifyCommerceModel {

    //WEBELEMENTS
    private String simplifyLoginURL = "https://www.simplify.com/commerce/login/auth";

    @FindBy(css = ".w--current.wl-logo")
    private WebElement loginPageLogo;

    @FindBy(css = ".leads.sub")
    private WebElement loginPageSubtitle;

    @FindBy(id = "username")
    private WebElement loginEmailAddress;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "button-login")
    private WebElement loginButton;

    @FindBy(css = ".js-forgotPasswordLnk")
    private WebElement resetPasswordLink;

    //GETTERS
    @Override
    public String getSimplifyLoginURL() {
        return simplifyLoginURL;
    }

    @Override
    public WebElement getLoginPageLogo() {
        return loginPageLogo;
    }

    @Override
    public WebElement getLoginPageSubtitle() {
        return loginPageSubtitle;
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
    public WebElement getResetPasswordLink() {
        return resetPasswordLink;
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
        System.out.println("Clicking Simplify Login button");
    }

    public void populateLoginDetails(String emailAddress, String password){
        populateEmailAddress(emailAddress);
        populatePassword(password);
        clickLoginBtn();
        System.out.println("User Log In");
    }

    public void clickResetPasswordLink(){
        gens.waitForElement(getResetPasswordLink(), defaultTimeout);
        gens.click(getResetPasswordLink());
        System.out.println("Clicking Reset Password Link");
    }

    public void verifyResetPasswordLink(){
        gens.waitForElement(getResetPasswordLink(), defaultTimeout);
        String expected = "https://www.simplify.com/commerce/login/forgotPassword";
        String link = getResetPasswordLink().getAttribute("href");
        gens.compareStrings(link, expected);
        System.out.println("Verifying Reset Password Link");
    }

    public void openSimplifyLogin(){
        gens.getURL(getSimplifyLoginURL());
        System.out.println("Navigating to " + getSimplifyLoginURL().toString());
    }
}
