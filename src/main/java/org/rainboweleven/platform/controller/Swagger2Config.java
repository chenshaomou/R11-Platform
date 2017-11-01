package org.rainboweleven.platform.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${jwt.header}")
    private String jwtHeader;

    @Bean
    public Docket createRestApi() {

        ParameterBuilder tokenParameterBuilder = new ParameterBuilder();
        tokenParameterBuilder.name(jwtHeader);
        tokenParameterBuilder.required(false);
        tokenParameterBuilder.description("令牌");
        tokenParameterBuilder.parameterType("header");
        tokenParameterBuilder.modelRef(new ModelRef("string"));

        List<Parameter> globalOperationParameters = new ArrayList<Parameter>();
        globalOperationParameters.add(tokenParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(globalOperationParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dcair.wxapp.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("多彩航空中台api", // 大标题
                "Spring boot + swagger + mybatis + druid", // 小标题
                "0.0.1", // 版本
                "NO terms of service", "chenshaomou@foreveross.com", // 作者
                "www.dcair.com", // 链接显示文字
                "http:/www.dcair.com/"// 网站链接
        );

        return apiInfo;
    }
}
