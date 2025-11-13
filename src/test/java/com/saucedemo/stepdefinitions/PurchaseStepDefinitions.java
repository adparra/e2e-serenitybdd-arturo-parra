package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.ConfirmationMessage;
import com.saucedemo.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    private Actor user;
    private JsonObject testData;

    @Before
    public void setTheStage() throws Exception {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.can(BrowseTheWeb.with(driver));

        // Load test data from JSON
        String content = new String(Files.readAllBytes(
                Paths.get("src/test/resources/testdata/purchaseData.json")));
        testData = new Gson().fromJson(content, JsonObject.class);
    }

    @Given("the user navigates to the SauceDemo page")
    public void theUserNavigatesToTheSauceDemoPage() {
        // Navigation happens in login step
    }

    @When("the user authenticates with valid credentials")
    public void theUserAuthenticatesWithValidCredentials() {
        JsonObject credentials = testData.getAsJsonObject("credentials");
        user.attemptsTo(
                Login.withCredentials(
                        credentials.get("username").getAsString(),
                        credentials.get("password").getAsString()
                )
        );
    }

    @When("adds two products to the cart")
    public void addsTwoProductsToTheCart() {
        user.attemptsTo(
                AddProducts.toCart()
        );
    }

    @When("views the shopping cart")
    public void viewsTheShoppingCart() {
        user.attemptsTo(
                ViewCart.inPage()
        );
    }

    @When("completes the purchase form with their data")
    public void completesThePurchaseFormWithTheirData() {
        JsonObject checkoutInfo = testData.getAsJsonObject("checkoutInfo");
        user.attemptsTo(
                FillCheckoutForm.withData(
                        checkoutInfo.get("firstName").getAsString(),
                        checkoutInfo.get("lastName").getAsString(),
                        checkoutInfo.get("postalCode").getAsString()
                )
        );
    }

    @When("finalizes the purchase")
    public void finalizesThePurchase() {
        user.attemptsTo(
                CompletePurchase.successfully()
        );
    }

    @Then("should see the confirmation message {string}")
    public void shouldSeeTheConfirmationMessage(String expectedMessage) {
        user.should(
                seeThat("the confirmation message",
                        ConfirmationMessage.displayed(),
                        equalTo(expectedMessage))
        );
    }
}