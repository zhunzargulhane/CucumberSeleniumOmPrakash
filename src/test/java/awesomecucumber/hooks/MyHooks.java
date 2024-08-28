package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.factory.DriverManagerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    TestContext testContext;

    public MyHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        /*testContext.scenarioName = scenario.getName();
        System.out.println("DI Before Hooks scenario name "+testContext.scenarioName);*/
        System.out.println("BEFORE THREAD ID" + Thread.currentThread().getId() + "," +
                "SCENARIO NAME " + scenario.getName());
        String browser = System.getProperty("browser", "CHROME");
        driver = DriverManagerFactory.getManager(browser).createDriver();
        //driver = new DriverFactory().initializeDriver(browser);
        testContext.driver = driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("AFTER THREAD ID" + Thread.currentThread().getId() + "," +
                "SCENARIO NAME " + scenario.getName());
        driver.quit();
    }
}
