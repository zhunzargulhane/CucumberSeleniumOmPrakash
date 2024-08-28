package awesomecucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyDummyStepDefinitions {
    @Given("dummy product")
    public void dummy_product() {
        System.out.println("given");
    }
    @When("i do dummy")
    public void i_do_dummy() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("when");
    }
    @Then("i verify dummy")
    public void i_verify_dummy() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("then");
    }

}
