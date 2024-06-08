package br.dev.ibere.automation.frontend.pages.swag.labs.logged;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class SwagLabsLoggedPageLocators {

    @Value("${logged.app.logo}")
    private String appLogo;

    @Value("${logged.hamburger.menu}")
    private String hamburgerMenu;

    @Value("${logged.hamburger.menu.inventory}")
    private String hamburgerMenuInventory;

    @Value("${logged.hamburger.menu.about}")
    private String hamburgerMenuAbout;

    @Value("${logged.hamburger.menu.logout}")
    private String hamburgerMenuLogout;

    @Value("${logged.hamburger.menu.reset.app}")
    private String hamburgerMenuResetApp;

    @Value("${logged.shopping.cart.link}")
    private String shoppingCartLink;

    @Value("${logged.shopping.cart.link.badge}")
    private String shoppingCartLinkBadge;

}
