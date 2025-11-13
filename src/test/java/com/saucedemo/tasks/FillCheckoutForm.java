package com.saucedemo.tasks;

import com.saucedemo.ui.CartPage;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutForm(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_FIELD),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }

    public static FillCheckoutForm withData(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckoutForm.class, firstName, lastName, postalCode);
    }
}