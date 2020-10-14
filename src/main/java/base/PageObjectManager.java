package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Generics;

import java.util.concurrent.TimeUnit;

public class PageObjectManager<T> {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Generics gens = new Generics();
    protected static int defaultTimeout = 5;

    protected PageObjectManager() {
        PageFactory.initElements(driver, this);
    }

    public void openBrowser(String browser) {
        getDriver(browser);
        browserWindowSetup();
        System.out.println("Opening Browser");
    }

    public void closeBrowser() {
        System.out.println("Closing Browser");
        driver.quit();
    }

    public WebDriver getDriver(String browser) {
        driver = null;
        String myChosenBrowser = browser.toLowerCase();
        String driverLocation = "src/main/resources/drivers/";
        if ("firefox".equals(myChosenBrowser)) {
            System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else if ("chrome".equals(myChosenBrowser)) {
            System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void browserWindowSetup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void setupWait(){
        wait = new WebDriverWait(driver, 40);
    }
}
