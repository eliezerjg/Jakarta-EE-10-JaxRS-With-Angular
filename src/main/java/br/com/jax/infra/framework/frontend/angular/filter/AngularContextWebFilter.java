package br.com.jax.infra.framework.frontend.angular.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

@WebFilter("/*")
public class AngularContextWebFilter implements Filter {

    private static final Set<String> EXCLUDED_PREFIXES = new HashSet<>(Set.of("/api", "/resources", "/static"));
    private static final Set<String> EXCLUDED_EXTENSIONS = new HashSet<>(Set.of(
            ".js", ".jpg", ".jpeg", ".png", ".css", ".gif", ".svg", ".woff", ".woff2", ".ttf", ".eot", ".ico", ".pdf"
    ));

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        if (shouldExcludeFromRedirect(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private boolean shouldExcludeFromRedirect(String requestURI) {
        return startsWithExcludedPrefix(requestURI) || endsWithExcludedExtension(requestURI);
    }

    private boolean startsWithExcludedPrefix(String requestURI) {
        return EXCLUDED_PREFIXES.stream().anyMatch(requestURI::startsWith);
    }

    private boolean endsWithExcludedExtension(String requestURI) {
        return EXCLUDED_EXTENSIONS.stream().anyMatch(requestURI::endsWith);
    }
}
