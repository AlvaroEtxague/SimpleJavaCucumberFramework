package pages;

import base.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnsplashPageMain extends PageObjectManager<UnsplashPageMain> implements UnsplashModel {

    //WEBELEMENTS
    private String baseURL = "https://unsplash.com/";

    @FindBy(css = "._1iWCF._27Bp2.jXmar")
    private WebElement subtitle;

    @FindBy(css = "li:nth-of-type(2) > ._1CBrG.qvEaq > ._1WMnM.xLon9")
    private WebElement architectureLink;

    @FindBy(id = "SEARCH_FORM_INPUT_homepage-header")
    private WebElement searchBar;

    @FindBy(css = "._18QGm")
    private WebElement searchBarBtn;

    //GETTERS
    public String getBaseURL() {
        return baseURL;
    }

    public WebElement getSubtitle() {
        return subtitle;
    }

    public WebElement getArchitectureLink() {
        return architectureLink;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getSearchBarBtn() {
        return searchBarBtn;
    }

    //PAGE INTERACTIONS
    public void clickArchitectureLink() {
        gens.waitForElement(getArchitectureLink(), 5);
        gens.click(getArchitectureLink());
        System.out.println("Clicking Architecture Link");
    }

    public void searchForImage(String text) {
        gens.waitForElement(getSearchBar(), 5);
        gens.type(text, getSearchBar());
        System.out.println("Searching for: " + text);
    }

    public void clickSearch(){
        gens.click(getSearchBarBtn());
        System.out.println("Clicking search button");
    }

    public void verifySubtitle(){
        gens.waitForElement(getSubtitle(), 3);
        String expected = "Powered by creators everywhere.";
        String actual = getSubtitle().getText();
        gens.compareStrings(actual, expected);
    }

    public void openUnsplashHome(){
        gens.getURL(getBaseURL());
    }
}
