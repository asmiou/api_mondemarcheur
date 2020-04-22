package com.mondemarcheur.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.awt.print.Pageable;
import java.util.Date;

@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
@Configuration
public class SwaggerConfiguration {

    private static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
    private static final String AUTHORIZATION_HEADER = "Authorization";

    /*@Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket = docket
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.mondemarcheur.api.entities"))
                .paths(PathSelectors.ant("/**"))

                .build();
        return docket;
    }*/
    @Bean
    public Docket swaggerSpringfoxDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //.pathMapping("/ui")
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                //.securityContexts(Lists.newArrayList(securityContext()))
                //.securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);

        docket = docket.select()
                .paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                //.apis(RequestHandlerSelectors.basePackage("com.mondemarcheur.api.entities"))
                .build();
        return  docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API - MonDemarcheur")
                .description("Ceci est l'API Rest-full du projet www.mondemarcheur.com \n " +
                        "Réalisé par: -Diallo Mamadou Hassimiou")
                .termsOfServiceUrl("")
                .contact(new Contact("Asmiou", "www.mondemarcheur.com", "mamadou-hassimiou.diallo@outlook.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
}