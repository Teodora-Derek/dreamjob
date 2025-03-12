package com.workplace.dreamjob.security.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workplace.dreamjob.dto.error.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ApplicationAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public ApplicationAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {

        log.error("Authentication exception occurred for request: {}", request, authException);

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(authException.getMessage());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        objectMapper.writeValue(response.getOutputStream(), apiErrorResponse);
    }
}
