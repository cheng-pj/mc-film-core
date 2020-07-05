package com.mc.film.common.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Mr.Cheng
 * @since 2020/6/14
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket adminApiConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("adminAPI")
				.apiInfo(adminApiInfo())
				.select()
				.paths(Predicates.and(PathSelectors.regex("/admin/.*")))
				.apis(RequestHandlerSelectors.basePackage("com.mc.film.controller.admin"))
				.build();
	}

	@Bean
	public Docket webApiConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("webAPI")
				.apiInfo(webApiInfo())
				.select()
				.paths(Predicates.and(PathSelectors.regex("/api/.*")))
				.apis(RequestHandlerSelectors.basePackage("com.mc.film.controller.web"))
				.build();
	}

	public ApiInfo adminApiInfo() {
		return new ApiInfoBuilder()
				.title("后台 API 文档")
				.description("测试 后台 api")
				.version("1.0")
				.build();
	}

	public ApiInfo webApiInfo() {
		return new ApiInfoBuilder()
				.title("web前端 API 文档")
				.description("测试 前端 api")
				.version("1.0")
				.build();
	}
}
