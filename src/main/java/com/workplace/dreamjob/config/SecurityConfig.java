package com.workplace.dreamjob.config;

import com.workplace.dreamjob.security.filter.SecurityAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@EnableMethodSecurity // allow to specify access via annotations
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final SecurityAuthenticationFilter securityAuthenticationFilter;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    private final AccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(securityAuthenticationFilter, AuthorizationFilter.class)
                .authorizeHttpRequests(matcher -> matcher
                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**",
                                "/swagger-resources", "/v3/api-docs/**", "/proxy/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/authentication/**").permitAll()
                        .anyRequest().authenticated())
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(customizer -> customizer.accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPoint));

        //        http.addFilterBefore(securityAuthenticationFilter, AuthorizationFilter.class)
        //                .cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
        //                .sessionManagement(
        //                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //                .exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler)
        //                        .authenticationEntryPoint(authenticationEntryPoint)).authorizeHttpRequests(
        //                        auth -> auth.requestMatchers(HttpMethod.POST, "/authentication/login", "/api/users")
        //                                .permitAll().anyRequest().authenticated());

        return http.build();
    }

    // register NoOp AuthenticationManager to avoid log printed by default autoconfiguration
    @Bean
    public AuthenticationManager noOpAuthenticationManager() {

        return authentication -> null;
    }
}
