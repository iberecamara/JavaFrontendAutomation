package br.dev.ibere.automation.frontend.runner;

import br.dev.ibere.automation.frontend.Automation;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberContextConfiguration
@SpringBootTest(classes = Automation.class)
public class CucumberSpringConfiguration {
}
