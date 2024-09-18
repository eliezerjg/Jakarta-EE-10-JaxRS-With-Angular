package br.com.jax.infra.servletcontainer.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebFilter("/*")
public class RequestInterceptorFilter implements Filter {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        String sessionId = (session != null) ? session.getId() : "No session";
        String requestPath = request.getRequestURI();

        StringBuilder params = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            for (String value : request.getParameterValues(paramName)) {
                params.append(" - %s: %s".formatted(paramName, value) );
            }
        }

        logger.info("Path: %s | Session ID: [%s] | Params: [%s]".formatted(requestPath, sessionId, params) );

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
