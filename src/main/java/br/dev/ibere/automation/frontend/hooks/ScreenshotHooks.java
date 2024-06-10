package br.dev.ibere.automation.frontend.hooks;

import br.dev.ibere.automation.frontend.exception.AutomationException;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
public class ScreenshotHooks {

    @Autowired
    private WebDriver driver;

    private final String screenshotsFolder = String.format("%s/screenshots", System.getProperty("user.dir"));


    @After(order = 10)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            log.debug("Scenario failed, taking screenshot...");
            TakesScreenshot driver = (TakesScreenshot) this.driver;
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            String fileName = String.format("%s/automation-selenium-screenshot-%s-%s-%s.png",
                    screenshotsFolder,
                    scenario.getId(),
                    scenario.getName().replace(' ', '_'),
                    ZonedDateTime.now()
                            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ssZ")));
            log.debug("Saving screenshot to: {}", fileName);
            createFolderIfNotPresent();
            scenario.attach(screenshot, "image/png", fileName);
            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(screenshot);
            } catch (FileNotFoundException e) {
                log.error("Folder not found! Screenshot not taken.", e);
            } catch (IOException e) {
                log.error("Error reading disk! Screenshot not taken.", e);
            }
        }
    }

    private void createFolderIfNotPresent() {
        File directory = new File(screenshotsFolder);
        if (!directory.exists()) {
            log.debug("Folder {} does not exist, creating it...", screenshotsFolder);
            if (directory.mkdir()) {
                log.debug("{} folder created.", screenshotsFolder);
            } else {
                throw new AutomationException(
                        String.format("Could not create screenshots folder at %s.", screenshotsFolder));
            }
        }
    }

}
