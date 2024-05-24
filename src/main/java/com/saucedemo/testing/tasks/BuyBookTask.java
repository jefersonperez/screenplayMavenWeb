package com.saucedemo.testing.tasks;

import com.saucedemo.testing.userinterfaces.HomePage;
import com.saucedemo.testing.utils.Constants;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.actions.*;


import java.io.IOException;

import static com.saucedemo.testing.tasks.LoginTask.excelUtils;
import static com.saucedemo.testing.tasks.buyBookFailedTask.excelFilePath;
import static com.saucedemo.testing.userinterfaces.HomePage.*;
import static com.saucedemo.testing.userinterfaces.LoginPage.TXT_PASSWORD;
import static com.saucedemo.testing.userinterfaces.LoginPage.TXT_USER_NAME;


public class BuyBookTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

    //HomePage.selectRandomBookAndSaveName(actor);
        try {
            excelUtils.setExcelFile(excelFilePath, Constants.Sheet_TestData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        actor.wasAbleTo(Click.on(BOOK_STORE));
        //actor.attemptsTo(Enter.theValue(excelUtils.getCellData(1, 0)).into(TXT_SHARE_BOOK));

        actor.attemptsTo(Enter.theValue(excelUtils.getCellData(1, 2)).into(TXT_SHARE_BOOK));
        actor.wasAbleTo((Click.on(LBL_BOOK_PROGRAMMING_JAVA)),
                Click.on(BTN_ADD));

        //actor.wasAbleTo(Click.on(BTN_ADD));


    }
    public static BuyBookTask buy() {
        return new BuyBookTask();
    }

}
