package com.saucedemo.testing.tasks;


import com.saucedemo.testing.utils.Constants;
import com.saucedemo.testing.utils.ExcelUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;

import static com.saucedemo.testing.userinterfaces.HomePage.*;


public class buyBookFailedTask implements Task {
    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            excelUtils.setExcelFile(excelFilePath, Constants.Sheet_TestData);

        } catch (IOException e) {
            e.printStackTrace();
        }


        actor.attemptsTo(Enter.theValue(excelUtils.getCellData(1, 2)).into(TXT_SHARE_BOOK));
        actor.wasAbleTo(Click.on(BOOK_LIST));

    }
    public static buyBookFailedTask buyfailed() {
        return Tasks.instrumented(buyBookFailedTask.class);
    }


}
