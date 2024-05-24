package com.saucedemo.testing.stepdefinitions;

import com.saucedemo.testing.tasks.LoginTask;
import com.saucedemo.testing.tasks.OpenBrowserTask;
import com.saucedemo.testing.tasks.ValidatePurchaseTask;
import com.saucedemo.testing.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.testing.tasks.*;

import java.io.IOException;

import static com.saucedemo.testing.tasks.ValidatePurchaseTask.validate;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class printParentFrameChildFrameStepDefinitions {
    @Managed(driver = "chrome")
    private WebDriver webDriver;
    private final Actor userAutomation = Actor.named("userAutomation");
    String path = Constants.Path_TestData + Constants.File_TestData;

    //Preparando al actor
    @Before
    public void prepareActorStage() {
        //Prepara todas las habilidades del actor (web, mobile, desktop)
        OnStage.setTheStage(new OnlineCast());
        //actor puede navegar en la web con el webdriver
        userAutomation.can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }


    @Given("^the user navigates to the Alerts, Frame & Windows module and selects Nested Frames$")
    public void iAmOnDemoQaPage() {


        userAutomation.attemptsTo(navigateAlertsFramesWindosTask.navigate());

    }


    @When("^the user extracts the text from Parent frame and chil iframe$")
    public void extractAndWriteFrameTextsToReport() {

        userAutomation.attemptsTo(
                printFramesTask.print()
        );
        // Obtener los textos de la memoria del actor
        String parentFrameText = userAutomation.recall("parentFrameText");
        String childIframeText = userAutomation.recall("childIframeText");

        // Escribir en el reporte
        Serenity.recordReportData().withTitle("Parent Frame Text").andContents(parentFrameText);
        Serenity.recordReportData().withTitle("Child Iframe Text").andContents(childIframeText);

    }
    @When("^the user navigates to the Practice Form module$")
    public void theUserNavigatesToThePracticeFormModule() {

        userAutomation.attemptsTo(navigatePracticeFormTask.navigatePractice());

    }

    @When("^the user fills the practice form with the following details$")
    public void theUserFillsThePracticeFormWithTheFollowingDetails() throws IOException, InvalidFormatException {
        userAutomation.attemptsTo(formsDataTask.forms());
    }
    @When("^the user submits the form$")
    public void theUserSubmitsTheForm() throws IOException, InvalidFormatException {
        userAutomation.attemptsTo(submitTask.submit());
    }


    }





