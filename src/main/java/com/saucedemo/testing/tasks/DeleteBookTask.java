package com.saucedemo.testing.tasks;

import com.saucedemo.testing.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.testing.userinterfaces.HomePage.*;

public class DeleteBookTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(BTN_DELETE));
        actor.wasAbleTo(Click.on(BTN_DELETE_OK));
    }
    public static DeleteBookTask delete() {
        return new DeleteBookTask();
    }


}
