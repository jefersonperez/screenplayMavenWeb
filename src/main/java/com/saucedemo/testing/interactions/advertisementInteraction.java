package com.saucedemo.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Evaluate;

public class advertisementInteraction implements Interaction {
    public static advertisementInteraction advertisement() {
        return Tasks.instrumented(advertisementInteraction.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Evaluate.javascript("document.querySelector('div[id^=\"google_ads_iframe_\"]').remove();")

        );
    }
}
