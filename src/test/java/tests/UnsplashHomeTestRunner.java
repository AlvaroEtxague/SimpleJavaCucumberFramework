package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/UnplashHome.feature",
        glue = {"stepdefinition"},
        monochrome = true,
        plugin = {"pretty", "json:target/JSONReports/BDD_Report.json"}
)

public class UnsplashHomeTestRunner {
}
