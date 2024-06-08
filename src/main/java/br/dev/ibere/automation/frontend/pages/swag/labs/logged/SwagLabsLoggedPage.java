package br.dev.ibere.automation.frontend.pages.swag.labs.logged;

import br.dev.ibere.automation.frontend.pages.swag.labs.base.SwagLabsBasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;


@Slf4j
@Component
public class SwagLabsLoggedPage extends SwagLabsBasePage {

    @Autowired
    private SwagLabsLoggedPageLocators locators;

    @Autowired
    private WebDriver driver;

    public Boolean isAppLogoDisplayed() {
        return !driver.findElements(By.className(locators.getAppLogo())).isEmpty();
    }

    public String getAppLogoText() {
        if (isAppLogoDisplayed()) {
            return driver.findElement(By.className(locators.getAppLogo())).getText();
        } else {
            return StringUtils.EMPTY;
        }
    }

}
