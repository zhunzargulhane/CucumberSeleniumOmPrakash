package awesomecucumber.pages;

import awesomecucumber.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(how = How.CSS, using = "a[title='View cart']")
    private WebElement viewCartLink;

    public void addToCart(String productName) {
        By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        waitUntilVisibilityOfElement(addToCartBtn).click();
        waitUntilElementToBeClickable(viewCartLink).click();
    }


}
