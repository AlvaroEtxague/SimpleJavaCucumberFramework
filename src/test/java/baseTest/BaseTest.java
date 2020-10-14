package baseTest;

import base.PageObjectManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Screenshots;

public class BaseTest extends PageObjectManager<BaseTest> {

    protected Screenshots screenshots;

    @BeforeMethod
    public void testSetup() {
        openBrowser("chrome");
    }

    @AfterMethod
    public void closeDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            screenshots = new Screenshots();
            System.out.println("FAILED: " + result.getMethod().getMethodName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("PASSED: " + result.getName());
        }
        closeBrowser();
    }
}
