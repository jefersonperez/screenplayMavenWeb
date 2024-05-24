package com.saucedemo.testing.userinterfaces;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class LoginPage {
    //Objetivos o elementos con los que interactura la pagina
    // publico  para todo el proyecto, static final: porque puede que no cambie a traves del tiempo
    public static final Target TXT_USER_NAME = Target.the("INPUT USERNAME").located(By.id("userName"));
    public static final Target TXT_PASSWORD = Target.the("INPUT PASSWORD").located(By.id("password"));
    public static final Target BTN_LOGIN = Target.the("BUTTON LOGIN").located(By.id("login"));
    public static final Target BTN_LOGIN_PAGE = Target.the("BUTTON LOGIN PAGE").located(By.xpath("//button[@id='login']"));
    public static final Target BTN_LOGOUT = Target.the("BUTTON LOGOUT").located(By.id("submit"));



    public static void ocultarPublicidad(WebDriver driver) {

        // Ejecuta JavaScript para ocultar el elemento de publicidad
        ((JavascriptExecutor) driver).executeScript(
                "var ads = document.querySelectorAll('a.ob-dynamic-rec-link');" +
                        "ads.forEach(function(ad) {" +
                        "   ad.style.display = 'none';" +
                        "});"
        );
        }

}
