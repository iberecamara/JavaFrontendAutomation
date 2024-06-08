package br.dev.ibere.automation.frontend.steps;

import br.dev.ibere.automation.frontend.pages.swag.labs.logged.SwagLabsLoggedPage;
import br.dev.ibere.automation.frontend.pages.swag.labs.login.SwagLabsLoginPage;
import br.dev.ibere.automation.frontend.steps.basic.SeleniumSteps;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Slf4j
public class ThenSteps extends SeleniumSteps {

    @Autowired
    private SwagLabsLoginPage loginPage;

    @Autowired
    private SwagLabsLoggedPage loggedPage;

    @Then("I can see {string} in the Accepted usernames list")
    public void validateUsernameInList(String username) {
        List<String> acceptedUsernames = getFromContext("acceptedUsernames");
        assertThat(acceptedUsernames, hasItem(username));
    }

    @Then("I validate the common password value")
    public void validateCommonPassword() {
        String commonPassword = getFromContext("commonPassword");
        assertThat(commonPassword, equalToIgnoringCase("secret_sauce"));
    }

    @Then("Login is {string}")
    public void verifyLoginStatus(String status) {
        Boolean shouldLogin = status.equalsIgnoreCase("successful");
        String message = shouldLogin ? "Login should be successful." : "Login shouldn't be successful.";
        assertThat(message,
                loggedPage.isAppLogoDisplayed(), is(shouldLogin));
    }

    @Then("I can see app logo text as Swag Labs")
    public void validateAppLogoText() {
        String appLogoText = loggedPage.getAppLogoText();
        assertThat("App logo text should match expected.",
                appLogoText, equalToIgnoringCase("Swag Labs"));
    }

    @Then("I can see {string} displayed as error message")
    public void validateErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat("Error message should match expected.",
                actualErrorMessage, equalToIgnoringCase(errorMessage));
    }

}