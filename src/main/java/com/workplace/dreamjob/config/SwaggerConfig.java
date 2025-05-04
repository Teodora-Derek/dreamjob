package com.workplace.dreamjob.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.workplace.dreamjob.common.constants.AuthConstants.AUTHORIZATION_HEADER;
import static com.workplace.dreamjob.common.constants.OpenApiConstants.TOKEN_SECURITY_REQUIREMENT;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(@Value("${server.servlet.context-path}") String contextPath) {

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(TOKEN_SECURITY_REQUIREMENT,
                                new SecurityScheme()
                                        .name(AUTHORIZATION_HEADER)
                                        .in(SecurityScheme.In.HEADER)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList(TOKEN_SECURITY_REQUIREMENT))
                .info(new Info()
                        .title("dreamjob")
                        .description("The dreamjob is responsible for finding the perfect job for you!")
                        .version("1.0"))
                .addServersItem(new Server().url(contextPath).description("dreamjob"));
    }
}
