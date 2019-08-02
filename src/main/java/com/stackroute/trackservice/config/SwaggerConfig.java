package com.stackroute.trackservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2 //annotation enables Swagger support in the class
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //select() method called on the Docket bean instance returns an ApiSelectorBuilder,
                // which provides the apis() and paths() methods that are used to filter the controllers
                // and methods that are being documented using String predicates.

                .select()

                //  RequestHandlerSelectors.basePackage predicate matches the guru.springframework.controllers
                //  base package to filter the API
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.trackservice"))

                // The regex parameter passed to paths()acts as an additional filter to generate documentation only
                // for the path starting with /product.

                .paths(regex("/api/v1.*"))
                .build();
    }
}
