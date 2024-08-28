package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainObjects.BillingDetails;
import io.cucumber.java.en.And;

public class CustomerStepDefinitions {
    TestContext testContext;

    public CustomerStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("The billing details are")
    public void theBillingDetailsAre(BillingDetails billingDetails) {

        testContext.billingDetails = billingDetails;
    }

}
