package pe.intercorp.retail.clientes.config;

import java.util.Collections;

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
public class SwaggerConfig {

	/**
	 * @author Ocares Hermosa Christopher
	 *
	 */

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("customers").select()
				.apis(RequestHandlerSelectors.basePackage("pe.intercorp.retail.clientes.controller")).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("REST API INTERCORP RETAIL - CLIENTES", "Reto Intercorp Retail", "API TOS",
				"Terms of service",
				new Contact("Christopher Boris Ocares Hermosa",
						"https://www.linkedin.com/in/christopher-boris-ocares-hermosa-73b38813b/",
						"chrisocares@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

}
