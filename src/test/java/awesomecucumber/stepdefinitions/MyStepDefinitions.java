/*
package awesomecucumber.stepdefinitions;


import awesomecucumber.constants.Endpoints;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.BillingDetails;
import awesomecucumber.domainObjects.Customer;
import awesomecucumber.domainObjects.Product;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import awesomecucumber.utils.ConfigLoader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

//import org.junit.Assert;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

//Based on the domain concept will split our step definition class example: cart page, store page, checkouit page
//so will achieve SRP
//Selenium imports must not be here in stepdefin class it should be in the POM classes.
//We should convert the data from gherkin files to domain objects using custom types.
//Datatable - custom datable type and for parameters custom parameter type.
//Scenarios must be independent of application state, user state, test data and driver instance.
//state of the test cases should not created from UI it should be done from the API
//application state like adding a product to the cart, creation of user for each scenario must be done using API
//and inject the cookies to the browser.
//remove hardcoding as much as possible for baseurl, static text. static text can be placed in xml.
//We should use Webdrivermanager to avoid incompatability of driver and chrome browser version.
//Multibrowser support should provide using maven command, Support for different environment this too require diff baseurl
//Custom type to convert the gherkin data to the domain objects like products,customer,address.
//Webdriver, domain objects, cookies to share among the steps using pico container dependency injection (Test context).
// In pojo classes can also use test context to shre the state in steps.


public class MyStepDefinitions {
    BillingDetails billingDetails;
    private final WebDriver driver; // scope of driver limited to the class.
    private String firstName;
    private String lastName;
    private String address_line1;
    private String city;
    private String state;
    private String zip;
    private String email;

    public MyStepDefinitions(TestContext testContext){
        */
/*System.out.println("IN StepDF DI scenario name is "+testContext.scenarioName);*//*

        driver=testContext.driver;
    }

    @Given("I'm on the store page")
    public void i_m_on_the_store_page() {
        */
/*WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*//*

    //    driver = DriverFactory.getDriver();
        new StorePage(driver).load(Endpoints.STORE.endpoint);

    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
       */
/* By addToCartBtn = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(5000*2);
        driver.findElement(viewCartLink).click();*//*

        new StorePage(driver).addToCart(product.getProductName());
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer qty, Product product) {
        // By productAddedCheckInCartPage = By.cssSelector("td[class='product-name'] a");
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), product.getProductName());
*/
/*        By productQuantity = By.xpath("//input[@type='number']");
        String actualValue = driver.findElement(productQuantity).getAttribute("value");*//*

        Assert.assertEquals((Integer) cartPage.getProductQty(), qty);

    }

    @Given("I'm a guest user")
    public void iMAGuestUser() {
       */
/* WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*//*

   //     driver = new DriverFactory().getDriver();
        new StorePage(driver).load(Endpoints.STORE.endpoint);
    }


   */
/* @And("The billing details are")
    public void theBillingDetailsAre(List<Map<String, String>> billingDetails) {
        firstName = billingDetails.get(0).get("firstName");
        lastName = billingDetails.get(0).get("lastname");
        address_line1 = billingDetails.get(0).get("address_line1");
        city = billingDetails.get(0).get("city");
        state = billingDetails.get(0).get("state");
        zip = billingDetails.get(0).get("zip");
        email = billingDetails.get(0).get("email");
    }*//*


    @And("The billing details are")
    public void theBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails=billingDetails;
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        */
/*By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(addToCartBtn).click();
        Thread.sleep(5000*2);
        driver.findElement(viewCartLink).click();*//*

        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        */
/*By proceedToCheckoutBtn = By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();*//*

        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnProceedToCheckoutBtn();
    }

    @When("I enter the billing address details")
    public void iEnterTheBillingAddressDetails() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingAddress(billingDetails);

    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
       */
/* Thread.sleep(5000);
        By placeOrderBtn = By.cssSelector("#place_order");
        driver.findElement(placeOrderBtn).click();*//*

        new CheckoutPage(driver).placeOrder();
    }

    @Then("Order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() throws InterruptedException {
        */
/*Thread.sleep(5000);
        By successNotice = By.cssSelector(".woocommerce-notice");
        String actualTextMsg = driver.findElement(successNotice).getText();*//*

        Assert.assertEquals(new CheckoutPage(driver).getNotice(), "Thank you. Your order has been received.");

    }

  */
/*  @DataTableType
    public Customer dataTableTransformer(Map<String,String> entry) {
        return new Customer(entry.get("username"), entry.get("password"));
    }*//*

    */
/*@Given("I'm entering credentials")
    public void i_m_entering_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<String> list = dataTable.values();
        System.out.println("USERNAME " + list.get(0));
        System.out.println("PASSWORD " + list.get(1));
    }*//*


    @Given("I'm entering credentials")
    public void i_m_entering_credentials(Customer customer) {

        System.out.println("USERNAME " + customer.getUsername());
        System.out.println("PASSWORD " + customer.getPassword());
    }


    @Given("I'm entering credentials multiple rows")
    public void iMEnteringCredentialsMultipleRows(List<Map<String, String>> customers) {

        for (Map<String, String> entry : customers) {
            System.out.println("USERNAME " + entry.get("username"));
            System.out.println("PASSWORD " + entry.get("password"));
        }
    }

    @Given("I'm entering credentials multiple rows using DataTableType")
    public void iMEnteringCredentialsMultipleRowsUsingDataTableType(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println("USERNAME " + customer.getUsername());
            System.out.println("PASSWORD " + customer.getPassword());
        }
    }

    @Given("I'm entering credentials single rows with header")
    public void iMEnteringCredentialsSingleRowsWithHeader(List<List<String>> customer) {
        System.out.println("USERNAME " + customer.get(1).get(0));
        System.out.println("USERNAME " + customer.get(1).get(1));
    }

    @Given("I'm entering credentials single row using DataTableType")
    public void iMEnteringCredentialsSingleRowUsingDataTableType(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer.getUsername() + " " + customer.getPassword());
        }
        */
/*System.out.println(customer.getUsername()+" "+customer.getPassword());
        customer.setUsername("myuserbeta");
        customer.setPassword("dfwef");*//*

    }

    @When("user use the credentials")
    public void userUseTheCredentials(Customer customer) {
        System.out.println("USING username " + customer.getUsername());
        System.out.println("USING password " + customer.getPassword());
    }

    @Given("I'm entering credentials single COLUMN with no header")
    public void iMEnteringCredentialsSingleCOLUMNWithNoHeader(*/
/*List<String> customer*//*
DataTable dataTable) {
        //System.out.println(customer.get(0)+" "+customer.get(1));
        List<String> customer = dataTable.asList();
        System.out.println(customer.get(0) + " " + customer.get(1));
    }

    @Given("I'm entering credentials single COLUMN with header")
    public void iMEnteringCredentialsSingleCOLUMNWithHeader(Map<String, String> customer) {
        System.out.println(customer.get("username") + " " + customer.get("password"));
    }

    */
/*@DataTableType
    public Customer dataTableTransformation(List<String> entry){
        return new Customer(entry.get(0),entry.get(1));
    }*//*


   */
/* @DataTableType
    public Customer dataTableTransformation(Map<String,String> entry){
        return new Customer(entry.get("username"),entry.get("password"));
    }*//*


  */
/*  @DataTableType
    public Customer dataTableTransformation(DataTable dataTable) {
        return new Customer(dataTable.row(0).get(1), dataTable.row(1).get(1));
    }*//*


    @Given("I'm entering credentials single column no header datatable type")
    public void iMEnteringCredentialsSingleColumnNoHeaderDatatableType(@Transpose Customer customer) {
        System.out.println(customer.getUsername() + " " + customer.getPassword());
    }

    @Given("I'm entering credentials single column with header datatable type")
    public void iMEnteringCredentialsSingleColumnWithHeaderDatatableType(Customer customer) {
        System.out.println(customer.getUsername() + " " + customer.getPassword());
    }
}
*/
