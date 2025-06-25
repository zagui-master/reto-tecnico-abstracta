package runners;


import browserManager.BrowserManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                "json:build/cucumber-reports/Cucumber.json",
                "html:build/cucumber-reports/cucumber-html-reports"
        },
        tags = "@Test01"

)
public class TestRunner {
    static BrowserManager browserManager = new BrowserManager();

    @AfterClass
    public static void tearDown() {
        browserManager.quitBrowser();
    }

}

