package com.saucedemo.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebElement;

import static com.saucedemo.testing.userinterfaces.HomePage.*;
import static com.saucedemo.testing.userinterfaces.HomePage.CHILD_IFRAME;

public class navigateAlertsFramesWindosTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.wasAbleTo(Click.on(LBL_FRAMES_ALERTS_WINDOWS),
                Click.on(LBL_NESTED_FRAMES));




    }




    public static navigateAlertsFramesWindosTask navigate() {
        return new navigateAlertsFramesWindosTask();
    }
}
