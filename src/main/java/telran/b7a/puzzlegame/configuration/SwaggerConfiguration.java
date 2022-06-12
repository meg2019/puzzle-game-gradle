package telran.b7a.puzzlegame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@EnableWebMvc
@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("telran.b7a.puzzlegame.controller"))
                .paths(PathSelectors.ant("/game/*"))
                .build()
                .apiInfo(Info());

    }

    private ApiInfo Info() {
        return new ApiInfo("Puzzle Game API", "API Docs for Puzzle Game", "1.0", null,
                null, null, null, Collections.emptyList());
    }
}
