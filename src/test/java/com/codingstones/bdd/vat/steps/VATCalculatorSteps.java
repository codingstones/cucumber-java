package com.codingstones.bdd.vat.steps;

import com.codingstones.bdd.vat.VATCalculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class VATCalculatorSteps {

    private VATCalculator vatCalculator;
    private float calculatedPrice;

    @Given("^I have a VAT calculator")
    public void i_get_with_price() throws Throwable {
        vatCalculator = new VATCalculator();
    }

    @When("^tax is calculated for \"(.*?)\" with (\\d+) price$")
    public void tax_is_calculated(String product, int price) throws Throwable {
        calculatedPrice = vatCalculator.calculateTotal(product, price);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(float priceWithVAT) throws Throwable {
        assertEquals(priceWithVAT, calculatedPrice, 0);
    }

    @Then("^the product rate is not found$")
    public void the_product_rate_is_not_found() throws Throwable {
        assertEquals(-1, calculatedPrice, 0);
    }
}