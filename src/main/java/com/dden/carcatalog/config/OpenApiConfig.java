package com.dden.carcatalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig
 *
 * @author Denys Parshutkin
 * @version 1.0.0
 */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI carFileOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Car REST API")
                        .description("Car stock")
                        .version("1.0"));
    }


}
