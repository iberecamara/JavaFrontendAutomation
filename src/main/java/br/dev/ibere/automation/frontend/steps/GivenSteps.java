package br.dev.ibere.automation.frontend.steps;

import br.dev.ibere.automation.frontend.pages.swag.labs.login.SwagLabsLoginPage;
import br.dev.ibere.automation.frontend.steps.basic.SeleniumSteps;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class GivenSteps extends SeleniumSteps {

    @Autowired
    private SwagLabsLoginPage loginPage;

    @Given("I open SwagLabs login page")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }

    @Given("I login with user {string}")
    public void loginWithUser(String username) {
        loginPage.openLoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(loginPage.getCommonPassword());
        loginPage.clickLoginButton();
    }

}