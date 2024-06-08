package br.dev.ibere.automation.frontend.pages.swag.labs.base;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public abstract class SwagLabsBasePage {

    @Value("${base.url}")
    protected String baseUrl;

    @Autowired
    protected BasicInputComponent inputComponent;

}
