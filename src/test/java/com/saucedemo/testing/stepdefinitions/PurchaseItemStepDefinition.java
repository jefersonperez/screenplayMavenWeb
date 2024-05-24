package com.saucedemo.testing.stepdefinitions;

import com.ibm.icu.impl.USerializedSet;
import com.saucedemo.testing.tasks.*;
import com.saucedemo.testing.utils.Constants;
import com.saucedemo.testing.utils.ExcelUtils;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class PurchaseItemStepDefinition {

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


    @Given("^I am on demoQa page$")
    public void iAmOnDemoQaPage() {
        userAutomation.attemptsTo(OpenBrowserTask.openBrowser());

    }


    @When("^I submit username and password$")
    public void iSubmitUsernameAndPassword() throws IOException, InvalidFormatException {
        userAutomation.attemptsTo(LoginTask.doLogin());
    }

    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() {

    }
    @Given("^I select a book at random$")
    public void iSelectABookAtRandom() {
        userAutomation.attemptsTo(BuyBookTask.buy());

    }
    @When("^I validate the messages$")
    public void iCompleteTheFields() {
            userAutomation.attemptsTo(ValidatePurchaseTask.validate());
    }

    @Then("^I delete book")
    public void iDeleteBook() {
userAutomation.attemptsTo(DeleteBookTask.delete());
    }
    @Given("^I select a non existent book$")
    public void iSelectANonExistentBook() {
        userAutomation.attemptsTo(buyBookFailedTask.buyfailed());

    }

}
