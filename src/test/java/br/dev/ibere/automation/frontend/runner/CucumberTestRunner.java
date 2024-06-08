package br.dev.ibere.automation.frontend.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/resources/features",},
        glue = {"br.dev.ibere.automation.frontend.steps",
                "br.dev.ibere.automation.frontend.hooks",
                "br.dev.ibere.automation.frontend.runner"},
        plugin = {"pretty",
                "br.dev.ibere.automation.frontend.selenium.config.SeleniumDriverLifecycle",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}

