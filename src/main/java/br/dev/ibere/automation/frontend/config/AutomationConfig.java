package br.dev.ibere.automation.frontend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value = {
        "classpath:configs/application.properties",
        "classpath:configs/urls.properties",
        "classpath:configs/urls-${env}.properties",
        "classpath:locators/login.properties",
        "classpath:locators/logged.properties",
}, ignoreResourceNotFound = true)
public class AutomationConfig {
}
