package com.mydom.hotelapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringConfig {

    @Bean
    OpenAPI configureOpenAPI() {
        return new OpenAPI().info(new Info().title("Hotel API"));
    }
}
