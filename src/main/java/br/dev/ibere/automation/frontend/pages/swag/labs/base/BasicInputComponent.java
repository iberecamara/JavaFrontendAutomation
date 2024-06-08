package br.dev.ibere.automation.frontend.pages.swag.labs.base;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class BasicInputComponent {

    public void clearInput(WebElement element) {
        clearInput(element, "clear");
    }

    public void clearInput(WebElement element, String type) {
        switch (type) {
            case "clear":
                element.clear();
                break;
            case "keys":
            default:
                deleteWithKeys(element);
                break;
        }
    }

    private static void deleteWithKeys(WebElement element) {
        element.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(Keys.END);
        for (int i = 0; i < element.getText().length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

}
