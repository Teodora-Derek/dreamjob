package com.workplace.dreamjob.security.filter;

import com.workplace.dreamjob.common.constants.AuthConstants;
import com.workplace.dreamjob.security.authentication.UserAuthentication;
import com.workplace.dreamjob.security.exception.TokenAuthenticationException;
import com.workplace.dreamjob.security.service.jwt.JwtService;
import com.workplace.dreamjob.security.model.AuthUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtService jwtService;

    public SecurityAuthenticationFilter(JwtService jwtService) {

        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String authenticationHeader = request.getHeader(AuthConstants.AUTHORIZATION_HEADER);

        if (authenticationHeader == null) {
            // Authentication token is not present, let's rely on anonymous authentication
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = stripBearerPrefix(authenticationHeader);
        AuthUser authUser = jwtService.resolveJwtToken(jwtToken);

        UserAuthentication authentication = new UserAuthentication(authUser);

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);

        filterChain.doFilter(request, response);
    }

    String stripBearerPrefix(String token) {

        if (!token.startsWith(BEARER_PREFIX)) {
            throw new TokenAuthenticationException("Unsupported authentication scheme");
        }

        return token.substring(7);
    }
}
