package com.github.alonwang.springexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author weilong.wang Created on 2018/9/5
 */
@Configuration
// 开启SpringFox 对 Swagger2 的支持
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket petApi() {
		// 说明要生成的文档是swagger 2.0的
		return new Docket(DocumentationType.SWAGGER_2)
				// 生成builder,为下边做准备
				.select()
				// 定义为哪些controller或model生成文档
				.apis(RequestHandlerSelectors.any())
				// 定义哪些路径需要包含
				.paths(PathSelectors.any()).build();
	}
}
