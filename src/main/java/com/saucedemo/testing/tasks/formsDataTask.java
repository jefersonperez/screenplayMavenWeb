package com.saucedemo.testing.tasks;

import com.saucedemo.testing.userinterfaces.FormsPage;
import com.saucedemo.testing.utils.Constants;
import com.saucedemo.testing.utils.ExcelUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.saucedemo.testing.userinterfaces.HomePage.LBL_FRAMES_ALERTS_WINDOWS;
import static com.saucedemo.testing.userinterfaces.HomePage.LBL_NESTED_FRAMES;
import static com.saucedemo.testing.userinterfaces.LoginPage.TXT_PASSWORD;
import static com.saucedemo.testing.userinterfaces.LoginPage.TXT_USER_NAME;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class formsDataTask implements Task {
    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            excelUtils.setExcelFile(excelFilePath, Constants.Sheet_TestData);

        } catch (IOException e) {
            e.printStackTrace();
        }

// Define the path to the image file relative to the project root
       // Path imagePath = Paths.get("src", "main", "resources", "imagenCargar.jpeg").toAbsolutePath();
        Path imagePath = Paths.get("src","main", "resources", "imagenCargrar.jpeg").toAbsolutePath();

        actor.attemptsTo(

                Enter.theValue(excelUtils.getCellData(1, 5)).into(FormsPage.INPUT_FIRST_NAME),
                Enter.theValue(excelUtils.getCellData(1, 6)).into(FormsPage.INPUT_LAST_NAME),
                Enter.theValue(excelUtils.getCellData(1, 7)).into(FormsPage.INPUT_EMAIL),
                Click.on(FormsPage.CHB_GENDER_FEMALE),
                Enter.theValue(excelUtils.getCellData(1, 8)).into(FormsPage.INPUT_NUMBER),
                //Click.on(FormsPage.INPUT_DATE_BIRTH),
                //Clear.field(FormsPage.INPUT_DATE_BIRTH),
                //Enter.theValue(excelUtils.getCellData(1, 9)).into(FormsPage.INPUT_DATE_BIRTH),
                //Hit.the(Keys.ENTER).into(FormsPage.INPUT_DATE_BIRTH),
                Click.on(FormsPage.INPUT_SUBJECTS),
                //Enter.keyValues(excelUtils.getCellData(1, 10)).into(FormsPage.INPUT_SUBJECTS),
                //Enter.theValue(excelUtils.getCellData(1, 10)).into(FormsPage.INPUT_SUBJECTS),
                Scroll.to(FormsPage.CHB_HOBBIES_MUSIC),
                Click.on(FormsPage.CHB_HOBBIES_MUSIC),
                Upload.theFile(imagePath).to(FormsPage.BTN_UPLOAD_IMAGE),
                Enter.theValue(excelUtils.getCellData(1, 12)).into(FormsPage.TXA_ADRESS)
                /*Click.on(FormsPage.INPUT_STATE),
                Click.on(FormsPage.INPUT_STATE.of(excelUtils.getCellData(1, 13))),
                Click.on(FormsPage.INPUT_CITY),
                Click.on(FormsPage.INPUT_CITY.of(excelUtils.getCellData(1, 14))),
                Click.on(FormsPage.BTN_SUBMIT)*/
        );


    }




    public static formsDataTask forms() {
        return new formsDataTask();
    }
}
