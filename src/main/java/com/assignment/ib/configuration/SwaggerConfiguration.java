package com.assignment.ib.configuration;
import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Swagger")
				.apiInfo(apiInfo())
				.select()
				.paths(any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("URL CUTTER")
				.description("URL Cutter Service with Swagger")
				.termsOfServiceUrl("https://www.infobip.com/terms-of-use")
				.contact(new Contact("Tarun Agarwal", "www.infobip.com", "tatarunaggarwal@gmail.com"))
				.version("2.0")
				.build();
	}

}
