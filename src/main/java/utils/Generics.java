package utils;

import base.PageObjectManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Generics extends PageObjectManager<Generics> {

    //METHOD TO TYPE TEXT INTO A WEBELEMENT
    public void type(String text, WebElement element) {
       element.sendKeys(text);
    }

    //METHOD TO CLICK A WEBELEMENT
    public void click(WebElement element) {
        element.click();
    }

    //METHOD TO GET ELEMENT LIST
    private List<WebElement> getElementList(WebElement element) {
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (elementList.isEmpty()){
            System.out.println("The following WebElement was NOT found: " + element);
        }
        else{
            System.out.println("The following WebElement was found: " + element);
        }
        return elementList;
    }

    //METHOD TO CHECK IF ELEMENT IS PRESENT ON THE PAGE
    public boolean isElementPresent(WebElement element){
        List<WebElement> elementList = getElementList(element);
        int size = elementList.size();
        if (size > 0){
            return true;
        }
        else{
            return false;
        }
    }

    //GENERIC METHOD THAT WAITS FOR AN ELEMENT TO BE VISIBLE ON THE PAGE
    public WebElement waitForElement(WebElement element1, int timeout){
        WebElement element = null;
        try{
            System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait =  new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOf(element1));
            System.out.println("Element appeared on the web page");
        }
        catch(Exception e){
            System.out.println("Element did not appear on the web page");
        }
        return element;
    }

    //GENERIC METHOD THAT ASSERTS 2 STRINGS
    public void compareStrings(String actual, String expected){
        Assert.assertEquals(actual, expected);
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
    }

    //METHOD TO CREATE A RANDOM STRING FOR SCREENSHOT NAME
    public String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public boolean existsElement(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String generateRandomNumber(int length) {
        StringBuilder numberBuilder = new StringBuilder();
        String characters = "123456789";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            numberBuilder.append(characters.charAt(index));
        }
        return numberBuilder.toString();
    }

    public void getURL(String url){
        driver.get(url);
    }

}
