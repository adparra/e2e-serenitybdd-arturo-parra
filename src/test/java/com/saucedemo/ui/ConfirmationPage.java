package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmationPage {
    public static final Target CONFIRMATION_HEADER = Target.the("encabezado de confirmación")
            .located(By.className("complete-header"));
}