package com.saucedemo.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.testing.userinterfaces.FormsPage.*;
import static com.saucedemo.testing.userinterfaces.HomePage.*;

public class submitTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.wasAbleTo(Click.on(BTN_SUBMIT),
                Click.on(BTN_CLOSE));





    }




    public static submitTask submit() {
        return new submitTask();
    }
}
