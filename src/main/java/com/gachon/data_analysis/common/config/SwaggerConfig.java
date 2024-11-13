package com.gachon.data_analysis.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Stock Data Analysis API",
                version = "1.0",
                description = "This is the API documentation for the Stock Data Analysis service."
        )
)
public class SwaggerConfig {
}