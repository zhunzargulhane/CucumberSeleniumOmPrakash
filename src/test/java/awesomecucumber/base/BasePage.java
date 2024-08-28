package awesomecucumber.base;

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void load(String endpoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }

    public WebElement waitUntilVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementToBeClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForOverlaysToDisappear(By element) {
        List<WebElement> overlays = driver.findElements(element);
        System.out.println("OVERLAY SIZE " + overlays.size());
        if (overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAY SIZE: After Invisible " + overlays.size());
        } else {
            System.out.println("OVERLAY NOT FOUND" + overlays.size());
        }
    }
}
