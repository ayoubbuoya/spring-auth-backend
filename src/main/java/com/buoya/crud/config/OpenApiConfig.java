package com.buoya.crud.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD WITH JWT AUTH")
                        .version("1.0.0")
                        .description("API documentation for your project"))
                .tags(List.of(new Tag().name("AUTH").description("Endpoints of JWT authenticate users")));
    }
}
