package br.dev.ibere.automation.frontend.context;

import br.dev.ibere.automation.frontend.exception.AutomationException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class Context {

    @Getter
    @Setter
    protected WebDriver driver;

    protected Map<String, Object> contextMap;

    public Context() {
        contextMap = new HashMap<>();
    }

    public void put(String key, Object value) {
        save(key, value);
    }

    public void update(String key, Object value) {
        save(key, value);
    }

    private void save(String key, Object value) {
        if (key.isEmpty()) {
            AutomationException e = new AutomationException("Key should not be empty.");
            log.error(e.getMessage(), e);
            throw e;
        }
        log.debug("Saved '{}':'{}' to context.", key, value);
        contextMap.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        if (key.isEmpty()) {
            log.debug("Key is empty, returning null.");
            return null;
        }
        if (!contextMap.containsKey(key)) {
            return null;
        }
        Object obj = contextMap.get(key);
        log.debug("Got '{}':'{}'.", key, obj);
        return (T) obj;
    }

    public void remove(String key) {
        if (key.isEmpty()) {
            log.debug("Key is empty, nothing to remove.");
            return;
        }
        contextMap.remove(key);
    }

    public void clear() {
        contextMap.clear();
    }

}
