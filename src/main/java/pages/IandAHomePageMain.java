package pages;

import base.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IandAHomePageMain extends PageObjectManager<IandAHomePageMain> implements IandAHomeModel {

    //WEBELEMENTS
    private String homePageURL = "https://api-test.allianz.com/ourhealth/2/groups";

    @FindBy(css = "#group-list-title")
    private WebElement homeMyGroupsTitle;

    //GETTERS
    @Override
    public String getIandAHomeURL() {
        return homePageURL;
    }

    @Override
    public WebElement getMyGroupsTitle() {
        return homeMyGroupsTitle;
    }

    //PAGE INTERACTIONS
    public void verifyGroupTitleHeading(){
        gens.waitForElement(getMyGroupsTitle(), defaultTimeout);
        String expected = "My Groups";
        String link = getMyGroupsTitle().getText();
        gens.compareStrings(link, expected);
        System.out.println("Verifying My Groups Heading");
    }

    public void verifyIandAHomePageUrl(){
        gens.waitForElement(getMyGroupsTitle(), defaultTimeout);
        String expected = "https://api-test.allianz.com/ourhealth/2/groups";
        String link = getIandAHomeURL();
        gens.compareStrings(link, expected);
        System.out.println("Verifying I&A Home Page URL");
    }

    public void openIandAHomePage(){
        gens.getURL(getIandAHomeURL());
        System.out.println("Navigating to " + getIandAHomeURL().toString());
    }
}
