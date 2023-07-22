package com.notepad.config;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * Description: swagger 配置
 * 地址：http://localhost:9090/swagger-ui.html
 * date: 2022/7/23
 *
 * @author Marvin Yang
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .directModelSubstitute(TimeStamp.class, Long.class)
                .directModelSubstitute(Date.class, Long.class)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Api")
                .version("1.0")
                .build();
    }
}
