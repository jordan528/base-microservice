package com.base.microservice.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Timotius Pamungkas", "", "");

		ApiInfo apiInfo = new ApiInfo("Security API", "Sample REST api for security", "Version 1.0",
				"http://www.google.com", contact, "No License", "http://www.google.com");

		return apiInfo;
	}

	@Bean
	@Profile("dev")
	public Docket dev() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/.*")).build().apiInfo(apiInfo()).enable(true);
	}

	@Bean
	@Profile({ "default", "test", "prod", "production" })
	public Docket other() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/.*")).build().apiInfo(apiInfo()).enable(false);
	}
	
}
