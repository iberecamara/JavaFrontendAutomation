package br.dev.ibere.automation.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.WebApplicationType.NONE;


@SpringBootApplication
public class Automation {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Automation.class).web(NONE).run();
    }

}