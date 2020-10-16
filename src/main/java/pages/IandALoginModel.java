package pages;

import org.openqa.selenium.WebElement;

public interface IandALoginModel {

    String getIandALoginURL();
    WebElement getLoginPageLogo();
    WebElement getLoginEmailAddress();
    WebElement getLoginPassword();
    WebElement getLoginButton();
    WebElement getForgotPasswordLink();
    WebElement getCookiesAcceptButton();
}
