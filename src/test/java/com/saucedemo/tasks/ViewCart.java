package com.saucedemo.tasks;

import com.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.SHOPPING_CART_LINK)
        );
    }

    public static ViewCart inPage() {
        return instrumented(ViewCart.class);
    }
}
