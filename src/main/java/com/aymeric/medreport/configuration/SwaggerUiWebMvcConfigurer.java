package com.aymeric.medreport.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.aymeric.medreport.controller.CustomerController;
import com.aymeric.medreport.controller.ReportController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Swagger web UI configuration class
 * URL:
 * json-file: http://localhost:8080/v2/api-docs
 * swagger-ui: http://localhost:8080/swagger-ui/
 */
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        ReportController.class,
        CustomerController.class
})
public class SwaggerUiWebMvcConfigurer {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("medreport-api")
                .apiInfo(apiInfo())
                .select()                                  
                .apis(RequestHandlerSelectors.any())              
                .paths(PathSelectors.any())                          
                .build();                                           
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Report  API")
                .description("Api for managing insurance reports")
                .version("0.1")
                .build();
    }
}
