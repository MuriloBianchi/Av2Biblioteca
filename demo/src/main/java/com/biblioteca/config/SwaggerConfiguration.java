package com.biblioteca.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("biblioteca")
                .pathsToMatch("/**")
                .packagesToScan("com.biblioteca.resources")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI(){
        return new io.swagger.v3.oas.models.OpenAPI()
            .info(new Info().title("bibliotecaOS")
                            .description("bibliotecaOS APIs")
                            .version("1.0")
                            .contact(new Contact()
                                 .name("Curso Spring")
                                 .url("http://www.cursospring.com.br")
                                 .email("cursospring@email.com")));
                            
    }
}
