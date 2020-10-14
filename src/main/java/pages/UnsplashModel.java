package pages;

import org.openqa.selenium.WebElement;

public interface UnsplashModel {
    String getBaseURL();
    WebElement getSubtitle();
    WebElement getArchitectureLink();
    WebElement getSearchBar();
    WebElement getSearchBarBtn();
}

