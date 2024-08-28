package awesomecucumber.stepdefinitions;

import awesomecucumber.apis.AddToCartAPI;
import awesomecucumber.constants.Endpoints;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.Product;
import awesomecucumber.pages.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private final WebDriver driver;
    private StorePage storePage;
    private TestContext testContext;

    public StoreStepDefinitions(TestContext testContext) {
        driver = testContext.driver;
        this.testContext = testContext;
        storePage = PageFactoryManager.getStorePage(driver);
    }

    @Given("I'm on the store page")
    public void i_m_on_the_store_page() {

        storePage.load(Endpoints.STORE.endpoint);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        storePage.addToCart(product.getProductName());
    }

    @And("I have a product in the cart")
    public void HaveAProductInTheCart() throws InterruptedException {
        AddToCartAPI addToCartAPI = new AddToCartAPI(testContext.cookies.getCookies());
        addToCartAPI.addProductToCart(1215, 1);
        Cookies cookies = addToCartAPI.getCookies();
        testContext.cookies.setCookies(cookies);
        testContext.cookies.injectCookiesToBrowser(testContext.driver);
        //storePage.addToCart("Blue Shoes");
    }

    @Given("I'm a guest user")
    public void iMAGuestUser() {
        storePage.load(Endpoints.STORE.endpoint);
    }
}
