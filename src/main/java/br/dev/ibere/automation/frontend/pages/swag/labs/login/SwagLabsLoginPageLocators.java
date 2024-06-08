package br.dev.ibere.automation.frontend.pages.swag.labs.login;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class SwagLabsLoginPageLocators {

    @Value("${login.accepted.usernames}")
    private String acceptedUsernames;

    @Value("${login.common.password}")
    private String commonPassword;

    @Value("${login.username.input}")
    private String usernameInput;

    @Value("${login.password.input}")
    private String passwordInput;

    @Value("${login.login.button}")
    private String loginButton;

    @Value("${login.error.message}")
    private String errorMessage;

}
