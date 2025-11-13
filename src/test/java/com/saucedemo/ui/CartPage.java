package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CHECKOUT_BUTTON = Target.the("botón de checkout")
            .located(By.id("checkout"));

    public static final Target CART_ITEMS = Target.the("items del carrito")
            .located(By.className("cart_item"));
}