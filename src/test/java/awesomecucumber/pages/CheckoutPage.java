package awesomecucumber.pages;

import awesomecucumber.base.BasePage;
import awesomecucumber.domainObjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#billing_first_name")
    private WebElement firstNameFld;
    @FindBy(css = "#billing_last_name")
    private WebElement lastNameFld;
    @FindBy(css = "#billing_address_1")
    private WebElement addressLineOneFld;
    @FindBy(css = "#billing_city")
    private WebElement cityFld;
    @FindBy(css = "#billing_postcode")
    private WebElement zipCodeFld;
    @FindBy(css = "#billing_email")
    private WebElement emailAddressFld;
    @FindBy(xpath = "//select[@id='billing_state']")
    private WebElement stateFld;
    @FindBy(css = "#place_order")
    private WebElement placeOrderBtn;

    @FindBy(css = ".woocommerce-notice")
    private WebElement successNotice;
    private By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage enterFirstNameFld(String firstName) {
        WebElement firstNameFldElement = waitUntilVisibilityOfElement(firstNameFld);
        firstNameFldElement.clear();
        firstNameFldElement.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastNameFld(String lastName) {
        WebElement lastNameFldElement = waitUntilVisibilityOfElement(lastNameFld);
        lastNameFldElement.clear();
        lastNameFldElement.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOneFld(String addressLineOne) {
        WebElement addressLineOneFldElement = waitUntilVisibilityOfElement(addressLineOneFld);
        addressLineOneFldElement.clear();
        addressLineOneFldElement.sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterCityFld(String city) {
        WebElement cityFldElement = waitUntilVisibilityOfElement(cityFld);
        cityFldElement.clear();
        cityFldElement.sendKeys(city);
        return this;
    }

    public CheckoutPage selectStateFld(String state) {
        WebElement stateFldElement = waitUntilVisibilityOfElement(stateFld);
        Select select = new Select(stateFldElement);
        select.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage enterZipCodeFld(String zip) {
        WebElement zipCodeFldElement = waitUntilVisibilityOfElement(zipCodeFld);
        zipCodeFldElement.clear();
        zipCodeFldElement.sendKeys(zip);
        return this;
    }

    public CheckoutPage enterEmailAddressFld(String email) {
        WebElement emailAddressFldElement = waitUntilVisibilityOfElement(emailAddressFld);
        emailAddressFldElement.clear();
        emailAddressFldElement.sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingDetails billingDetails) {
        enterFirstNameFld(billingDetails.getFirstName()).
                enterLastNameFld(billingDetails.getLastName()).
                enterAddressLineOneFld(billingDetails.getAddress_line1()).
                selectStateFld(billingDetails.getState()).
                enterCityFld(billingDetails.getCity()).
                enterZipCodeFld(billingDetails.getZip()).
                enterEmailAddressFld(billingDetails.getEmail());
        return this;
    }

    public CheckoutPage placeOrder() {
        waitForOverlaysToDisappear(overlay);
        placeOrderBtn.click();
        return this;
    }

    public String getNotice() {
        return waitUntilVisibilityOfElement(successNotice).getText();
    }

}

