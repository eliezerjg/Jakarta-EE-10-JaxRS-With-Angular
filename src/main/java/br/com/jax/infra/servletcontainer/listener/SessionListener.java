package br.com.jax.infra.servletcontainer.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.logging.Logger;

@WebListener
public class SessionListener implements HttpSessionListener {

    private Logger logger;

    public SessionListener() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        StringBuilder logParams = new StringBuilder();
        event.getSession().getAttributeNames().asIterator().forEachRemaining(param -> {
            logParams.append(" - param: ").append(param)
                    .append(" - value: ").append(event.getSession().getAttribute(param))
                    .append(" \n");
        });

        logger.info(String.format("[%s] - Session created [%s] - Params: [%s]",
                java.time.LocalDateTime.now(), event.getSession().getId(), logParams));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info(String.format("[%s] - Session destroyed [%s]",
                java.time.LocalDateTime.now(), event.getSession().getId()));
    }
}
