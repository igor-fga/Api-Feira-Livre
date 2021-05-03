package br.gov.sp.prefeitura.feira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket filialApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.gov.sp.prefeitura.feira")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Api - Feira Livre")
				.description("Api para CRUD de feiras livres da cidade de São Paulo.").version("1.0.0")
				.license("Apache License Version 2.0")
				.contact(new Contact("Igor Andrade",
						"https://www.linkedin.com/in/ifgandrade/",
						"ifgandrade@gmail.com"))
				.build();
	}

}
