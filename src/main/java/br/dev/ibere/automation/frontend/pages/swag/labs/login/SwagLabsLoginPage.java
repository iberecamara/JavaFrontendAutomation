package br.dev.ibere.automation.frontend.pages.swag.labs.login;

import br.dev.ibere.automation.frontend.pages.swag.labs.base.SwagLabsBasePage;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.dev.ibere.automation.frontend.pages.swag.labs.login.SwagLabsLoginPageConstants.ACCEPTED_USERNAMES_TEXT;
import static br.dev.ibere.automation.frontend.pages.swag.labs.login.SwagLabsLoginPageConstants.COMMON_PASSWORD_TEXT;


@Slf4j
@Component
public class SwagLabsLoginPage extends SwagLabsBasePage {

    @Autowired
    private SwagLabsLoginPageLocators locators;

    @Autowired
    private WebDriver driver;

    public void openLoginPage() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public List<String> getAcceptedUsernames() {
        var div = driver.findElement(By.id(locators.getAcceptedUsernames()));
        var usernames = Lists.newArrayList(div.getText().split("\n"));
        usernames.removeIf(s -> s.equals(ACCEPTED_USERNAMES_TEXT));
        return usernames;
    }

    public String getCommonPassword() {
        var div = driver.findElement(By.className(locators.getCommonPassword()));
        return div.getText().replace(COMMON_PASSWORD_TEXT, "").trim();
    }

    public void setUsername(String username) {
        var input = driver.findElement(By.id(locators.getUsernameInput()));
        inputComponent.clearInput(input);
        input.sendKeys(username);
    }

    public void setPassword(String password) {
        var input = driver.findElement(By.id(locators.getPasswordInput()));
        inputComponent.clearInput(input);
        input.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id(locators.getLoginButton())).click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath(locators.getErrorMessage())).getText();
    }

}
