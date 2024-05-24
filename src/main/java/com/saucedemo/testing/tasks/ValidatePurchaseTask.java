package com.saucedemo.testing.tasks;

import com.saucedemo.testing.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import static com.saucedemo.testing.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidatePurchaseTask implements Task {

    private final int pixelsToScroll;
    private String text;
   HomePage homePage;
    public ValidatePurchaseTask(int pixelsToScroll){
        this.pixelsToScroll = pixelsToScroll;
    }
public static ValidatePurchaseTask byPixels(int pixelsToScroll){
        return instrumented((ValidatePurchaseTask.class),pixelsToScroll);
}


    @Override
    public <T extends Actor> void performAs(T actor) {
        String bookComp = actor.recall("selected book name");

        JavascriptExecutor js = (JavascriptExecutor) actor.usingAbilityTo(BrowseTheWeb.class).getDriver();
        js.executeScript("window.scrollBy(0,arguments[0]);",pixelsToScroll);
        actor.wasAbleTo(Click.on(BTN_PROFILE));
        text = TextContent.of(BOOK_LIST).viewedBy(actor).asString();
        System.out.println(text);

        if(text.equals(bookComp)){

        }else {

        }

    }
    public static ValidatePurchaseTask validate() {
        return new ValidatePurchaseTask(500);
    }

}
