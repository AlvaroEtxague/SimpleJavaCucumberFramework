package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/SimplifyLogin.feature",
        glue = {"stepdefinition"},
        monochrome = true,
        plugin = {"pretty", "json:target/JSONReports/BDD_Report.json"}
//        tags = ""
)
public class SimplifyLoginTestsRunner {
}


