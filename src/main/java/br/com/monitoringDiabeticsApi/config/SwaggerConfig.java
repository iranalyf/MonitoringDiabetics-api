package br.com.monitoringDiabeticsApi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("br.com.monitoringDiabeticsApi"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "API Monitoring Diabetics",
                "API Monitoring Diabetics",
                "1.0",
                "Terms of service",
                new Contact("The name Organizations", "website", "email"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}

