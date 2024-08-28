package awesomecucumber.pages;

import awesomecucumber.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "td[class='product-name'] a")
    private WebElement productNameFld;

    @FindBy(how = How.XPATH, using = "//input[@type='number']")
    private WebElement productQtyFld;

    @FindBy(how=How.CSS,using=".checkout-button")
    private WebElement proceedToCheckoutBtn;

    public String getProductName() {
        return waitUntilVisibilityOfElement(productNameFld).getText();
    }

    public int getProductQty() {
        return Integer.parseInt(waitUntilVisibilityOfElement(productQtyFld).getAttribute("value"));
    }

    public void checkout(){
        waitUntilElementToBeClickable(proceedToCheckoutBtn).click();
    }
}
