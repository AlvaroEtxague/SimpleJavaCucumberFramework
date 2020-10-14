package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/UnplashHome.feature",
        glue = {"stepdefinition"}
)

public class UnsplashHomeTestRunner {
}
