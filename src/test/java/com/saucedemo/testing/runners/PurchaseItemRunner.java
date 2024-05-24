package com.saucedemo.testing.runners;

import com.saucedemo.testing.utils.Constants;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features = "src\\test\\resources\\com.saucedemo.testing.features\\purchase.feature",
@CucumberOptions(features = "src/test/resources/com.saucedemo.testing.features/purchase.feature",
glue="com.saucedemo.testing.stepdefinitions",
snippets = SnippetType.CAMELCASE)
public class PurchaseItemRunner {
}
