package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target FIRST_NAME_FIELD = Target.the("campo nombre")
            .located(By.id("first-name"));

    public static final Target LAST_NAME_FIELD = Target.the("campo apellido")
            .located(By.id("last-name"));

    public static final Target POSTAL_CODE_FIELD = Target.the("campo código postal")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.id("continue"));

    public static final Target FINISH_BUTTON = Target.the("botón finalizar")
            .located(By.id("finish"));
}