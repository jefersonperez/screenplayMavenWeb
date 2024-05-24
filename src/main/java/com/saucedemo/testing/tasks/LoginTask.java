package com.saucedemo.testing.tasks;

import com.saucedemo.testing.interactions.advertisementInteraction;
import com.saucedemo.testing.utils.Constants;
import com.saucedemo.testing.utils.DataProvider;
import com.saucedemo.testing.utils.ExcelUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.saucedemo.testing.userinterfaces.LoginPage.*;

public class LoginTask implements Task {

    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            excelUtils.setExcelFile(excelFilePath, Constants.Sheet_TestData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriver driver = null;

        actor.wasAbleTo(Click.on(BTN_LOGIN));
        actor.attemptsTo(Enter.theValue(excelUtils.getCellData(1, 0)).into(TXT_USER_NAME),
                Enter.theValue(excelUtils.getCellData(1, 1)).into(TXT_PASSWORD));


        actor.attemptsTo(advertisementInteraction.advertisement(),
                Click.on(BTN_LOGIN_PAGE));
        //  actor.wasAbleTo(Click.on(BTN_LOGIN_PAGE));


        driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));

    }

    public static LoginTask doLogin() {
        return Tasks.instrumented(LoginTask.class);
    }
}
