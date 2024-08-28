package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(glue = {"awesomecucumber"},
        features = "src/test/resources/awesomecucumber",
        plugin = "html:target/cucumber/cucumber.html",
        tags = "@dummy")
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}
