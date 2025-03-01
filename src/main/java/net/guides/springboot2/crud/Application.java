package net.guides.springboot2.crud;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/employee/**"))
				.apis(RequestHandlerSelectors.basePackage("net.guides.springboot2.crud"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo("Spring Boot CRUD Operation",
				"Restful API's",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Praneet", "Simple Project","praneet@gmail.com"),
				"API Lists",
				"www.dummy.com",
				Collections.emptyList());
	}
}
