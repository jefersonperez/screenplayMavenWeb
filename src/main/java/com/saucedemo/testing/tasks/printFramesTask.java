package com.saucedemo.testing.tasks;

import com.saucedemo.testing.userinterfaces.HomePage;
import com.saucedemo.testing.utils.Constants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;
import java.time.Duration;

import static com.saucedemo.testing.tasks.LoginTask.excelUtils;
import static com.saucedemo.testing.tasks.buyBookFailedTask.excelFilePath;
import static com.saucedemo.testing.userinterfaces.HomePage.*;
import static com.saucedemo.testing.userinterfaces.HomePage.BTN_ADD;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class printFramesTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Esperar a que el frame wrapper esté presente y visible
        WebElement frameWrapper = driver.findElement(By.id("frame1Wrapper"));

        // Obtener el primer iframe dentro del frame wrapper
        WebElement parentIframe = frameWrapper.findElement(By.tagName("iframe"));

        // Cambiar al contexto del primer iframe
        driver.switchTo().frame(parentIframe);

        // Obtener el texto del primer iframe
        String parentFrameText = driver.findElement(By.tagName("body")).getText().trim();

        // Imprimir el texto del primer iframe
        System.out.println("Parent Frame Text: " + parentFrameText);

        // Cambiar al contexto del primer iframe para buscar el segundo iframe
        driver.switchTo().frame(0); // Cambia al primer iframe dentro del primero

        // Obtener el texto del segundo iframe
        String childIframeText = driver.findElement(By.tagName("body")).getText().trim();

        // Imprimir el texto del segundo iframe
        System.out.println("Child Iframe Text: " + childIframeText);

        // Cambiar al contexto principal
        driver.switchTo().defaultContent();

        // Guardar los textos en la memoria del actor
        actor.remember("parentFrameText", parentFrameText);
        actor.remember("childIframeText", childIframeText);



    /*   WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Esperar a que el frame wrapper esté presente y visible
        WebElement frameWrapper = ((WebDriver) driver).findElement(By.id("frame1Wrapper"));

        // Obtener el primer iframe dentro del frame wrapper
        WebElement iframe = frameWrapper.findElement(By.tagName("iframe"));

        // Cambiar al contexto del primer iframe
        driver.switchTo().frame(iframe);

        // Obtener el texto del primer iframe
        String parentFrameText = driver.findElement(By.tagName("body")).getText().trim();

        // Cambiar al contexto principal
        driver.switchTo().defaultContent();

        // Obtener el segundo iframe dentro del primer iframe
        WebElement childIframe = frameWrapper.findElement(By.tagName("iframe"));

        // Cambiar al contexto del segundo iframe
        driver.switchTo().frame(childIframe);

        // Obtener el texto del segundo iframe
        String childIframeText = driver.findElement(By.tagName("body")).getText().trim();

        // Cambiar al contexto principal
        driver.switchTo().defaultContent();

        // Imprimir los textos obtenidos
        System.out.println("Parent Frame Text: " + parentFrameText);
        System.out.println("Child Iframe Text: " + childIframeText);

        // Guardar los textos en la memoria del actor
        actor.remember("parentFrameText", parentFrameText);
        actor.remember("childIframeText", childIframeText);

*/





    }




    public static printFramesTask print() {
        return instrumented(printFramesTask.class);
        //return new printFramesTask();
    }
}

