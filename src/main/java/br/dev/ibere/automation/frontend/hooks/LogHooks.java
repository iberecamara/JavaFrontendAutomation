package br.dev.ibere.automation.frontend.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LogHooks {

    @Before(order = 0)
    public void logBeforeScenario() {
        log.info("-------------------------------------------STARTING TEST-------------------------------------------");
    }

    @After(order = 0)
    public void logAfterScenario(Scenario scenario) {
        log.info("---------------------------------------TEST FINISHED: {}---------------------------------------",
                scenario.getStatus().toString().toUpperCase());
    }

}
