package com.codingstones.bdd.bichomania.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


import static org.junit.Assert.assertEquals;

public class CartSteps {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-mac");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
        webDriver = new FirefoxDriver(options);
    }

    @After
    public void tearDown() {
        if(webDriver != null){
            webDriver.quit();
        }
    }

    @Given("^an empty cart$")
    public void an_empty_cart() throws Throwable {
        webDriver.get("http://www.bichomania.es/cart");
        List lineItems = webDriver.findElements(By.id("line_items"));
        assertEquals(0, lineItems.size());
    }

    @Given("^I am looking for a dog product$")
    public void i_am_looking_for_a_dog_product() throws Throwable {
        webDriver.get("http://www.bichomania.es/t/categorias/perros");
        WebElement productAnchor = webDriver.findElement(By.cssSelector("div.product-item a"));
        productAnchor.click();

    }

    @When("^I add the product to the cart$")
    public void i_add_the_product_to_the_cart() throws Throwable {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
        WebElement addToCart = webDriver.findElement(By.id("add-to-cart-button"));
        addToCart.click();
    }

    @Then("^the product should be present in my cart$")
    public void the_product_should_be_present_in_my_cart() throws Throwable {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("line_items")));
        WebElement lineItems = webDriver.findElement(By.id("line_items"));
        List items = lineItems.findElements(By.className("line-item"));
        assertEquals(1, items.size());
    }
}
