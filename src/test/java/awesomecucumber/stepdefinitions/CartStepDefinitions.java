package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.Endpoints;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    private final WebDriver driver;
    private CartPage cartPage;

    public CartStepDefinitions(TestContext testContext) {
        driver = testContext.driver;
        cartPage = PageFactoryManager.getCartPage(driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer qty, Product product) {
        //CartPage cartPage = new CartPage(driver);
        //CartPage cartPage = PageFactoryManager.getCartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), product.getProductName());
        Assert.assertEquals((Integer) cartPage.getProductQty(), qty);
    }


}
