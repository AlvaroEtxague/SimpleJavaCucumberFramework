package pages;

import org.openqa.selenium.WebElement;

public interface SimplifyCommerceModel {

    String getSimplifyLoginURL();
    WebElement getLoginPageLogo();
    WebElement getLoginPageSubtitle();
    WebElement getLoginEmailAddress();
    WebElement getLoginPassword();
    WebElement getLoginButton();
    WebElement getResetPasswordLink();

}
