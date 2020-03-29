package com.company.paymentservice.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2Config {

    private static final String SWAGGER_API_VERSION = "2.9.2";
    private static final String LICENSE_TEXT = "License. This is a open source project for who wants to learn how to develop full-stack api.";
    private static final String title = "Springular Rest API";
    private static final String description = "RESTful API Documentation for Payment Service";

    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.userapi.controller"))
                .paths(PathSelectors.regex("/user.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }
}
