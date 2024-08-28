package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.Endpoints;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.BillingDetails;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private final WebDriver driver;
    private final BillingDetails billingDetails;
    private CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext testContext) {
        driver = testContext.driver;
        billingDetails = testContext.billingDetails;
        checkoutPage = PageFactoryManager.getCheckoutPage(driver);
    }

    @When("I enter the billing address details")
    public void iEnterTheBillingAddressDetails() {
        /*CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingAddress(billingDetails);*/
        checkoutPage.setBillingAddress(billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        checkoutPage.placeOrder();
    }

    @Then("Order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(Endpoints.CHECKOUT.endpoint);
     /*   //CartPage cartPage = new CartPage(driver);
        cartPage.load(Endpoints.CHECKOUT.endpoint);
        cartPage.checkout();*/
        //cartPage.checkout();
    }
}
