package com.isRezende.api_transacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().info(new Info().title("API Transações").version("1.0")
                .description("API para transações financeiras"));
    }
}
