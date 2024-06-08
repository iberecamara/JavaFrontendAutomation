package br.dev.ibere.automation.frontend.steps.basic;

import br.dev.ibere.automation.frontend.context.ContextProvider;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseSteps {

    @Autowired
    protected ContextProvider context;

    protected void putInContext(String key, Object value) {
        context.get().put(key, value);
    }

    protected void updateInContext(String key, Object value) {
        context.get().update(key, value);
    }

    protected <T> T getFromContext(String key) {
        return context.get().get(key);
    }

    protected void removeFromContext(String key) {
        context.get().remove(key);
    }

    protected void clearContext() {
        context.get().clear();
    }

}