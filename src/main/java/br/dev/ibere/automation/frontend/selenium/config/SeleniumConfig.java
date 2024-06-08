package br.dev.ibere.automation.frontend.selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Slf4j
@Configuration
public class SeleniumConfig {

    @Bean
    @Scope("singleton")
    @ConditionalOnProperty(prefix = "browser", name = "name", havingValue = "chrome")
    public WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        log.info("Successfully created Selenium Chrome driver.");
        return driver;
    }

    @Bean
    @Scope("singleton")
    @ConditionalOnProperty(prefix = "browser", name = "name", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        log.info("Successfully created Selenium Firefox driver.");
        return driver;
    }

    @Bean
    @Scope("singleton")
    @ConditionalOnProperty(prefix = "browser", name = "name", havingValue = "ie")
    public WebDriver getIeDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        log.info("Successfully created Selenium IE driver.");
        return driver;
    }

    @Bean
    @Scope("singleton")
    @ConditionalOnProperty(prefix = "browser", name = "name", havingValue = "edge")
    public WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        log.info("Successfully created Selenium Edge driver.");
        return driver;
    }

}
