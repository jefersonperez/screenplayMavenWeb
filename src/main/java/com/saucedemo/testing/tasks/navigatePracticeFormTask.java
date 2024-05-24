package com.saucedemo.testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.testing.userinterfaces.HomePage.*;

public class navigatePracticeFormTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.wasAbleTo(Click.on(LBL_FORMS),
                Click.on(LBL_PRACTICE_FORM));




    }




    public static navigatePracticeFormTask navigatePractice() {
        return new navigatePracticeFormTask();
    }
}
