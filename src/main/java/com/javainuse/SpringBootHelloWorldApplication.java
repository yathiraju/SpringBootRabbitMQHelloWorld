package com.javainuse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class , args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.javainuse.controller")).build()
				.securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
	}
	
	
	 private SecurityContext securityContext() {
         return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
       }

     private List<SecurityReference> defaultAuth() {
       final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
       final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
       return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
     }

     private ApiKey apiKey() {
       return new ApiKey("Bearer", "Authorization", "header");
     } 
}