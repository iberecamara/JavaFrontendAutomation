package br.dev.ibere.automation.frontend.steps;

import br.dev.ibere.automation.frontend.pages.swag.labs.login.SwagLabsLoginPage;
import br.dev.ibere.automation.frontend.steps.basic.SeleniumSteps;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class WhenSteps extends SeleniumSteps {

    @Autowired
    private SwagLabsLoginPage loginPage;

    @When("I retrieve the {string} from Login page")
    public void getInformationFromLoginPage(String value) {
        switch (value) {
            case "Accepted usernames":
                putInContext("acceptedUsernames",
                        loginPage.getAcceptedUsernames());
                break;
            case "Password for all users":
                putInContext("commonPassword",
                        loginPage.getCommonPassword());
                break;
        }
        log.info("Retrieved '{}' data from Swag Labs Login page.", value);
    }

    @When("I set the username as {string}")
    public void setUsername(String username) {
        loginPage.setUsername(username);
        log.info("Set '{}' as username.", username);
    }

    @When("I set the password as {string}")
    public void setPassword(String password) {
        if (password.equals("common password")) {
            password = loginPage.getCommonPassword();
            log.debug("Changing password value to the common password '{}'.", password);
        }
        loginPage.setPassword(password);
        log.info("Set '{}' as password.", password);
    }

    @When("I click Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
        log.info("Clicked login button.");
    }

}