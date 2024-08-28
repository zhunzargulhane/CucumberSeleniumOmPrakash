package awesomecucumber.factory;

import awesomecucumber.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
   // private static final ThreadLocal<WebDriver> driver = new ThreadLocal();

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (DriverType.valueOf(browser)) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("INVALID BROWSER NAME " + browser);
        }
        driver.manage().window().maximize();
        //DriverFactory.driver.set(driver);
        return driver;
    }

   /* public static WebDriver getDriver() {
        return driver.get();
    }*/
}
