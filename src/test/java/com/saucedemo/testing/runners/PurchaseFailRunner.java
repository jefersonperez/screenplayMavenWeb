package com.saucedemo.testing.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\com.saucedemo.testing.features\\purchaseFail.feature",
        glue="com.saucedemo.testing.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class PurchaseFailRunner {
}
