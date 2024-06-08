package br.dev.ibere.automation.frontend.selenium.config;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SeleniumDriverLifecycle implements ConcurrentEventListener {

    @Autowired
    WebDriver driver;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunFinished.class,
                event -> afterAll());
    }

    private void afterAll() {
        if (null == driver) {
            log.info("Selenium driver already closed, no action to take.");
        } else {
            log.info("Selenium driver still active, closing it...");
            driver.quit();
        }
    }

}
