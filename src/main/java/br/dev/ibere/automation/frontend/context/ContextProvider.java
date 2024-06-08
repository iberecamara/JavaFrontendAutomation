package br.dev.ibere.automation.frontend.context;

import org.springframework.stereotype.Component;


@Component
public class ContextProvider {

    private static final ThreadLocal<Context> threadContext = new ThreadLocal<>();

    public Context get() {
        Context context = threadContext.get();
        if (context == null) {
            context = new Context();
            threadContext.set(context);
        }
        return context;
    }
}
