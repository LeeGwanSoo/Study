package kr.co.joneconsulting.myrestfulservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info( title = "title"
                ,description = "description"
                ,version = "1.0.0"
        )
)
@Configuration
@RequiredArgsConstructor
public class NewSwaggerConfig {
        @Bean
        public GroupedOpenApi CustomTestOpenApi() {
                String[] paths =  {"/users/**", "/admin/**"};
                return
                        GroupedOpenApi.builder()
                                .group("testgroup")
                                .pathsToMatch(paths)
                                .build()
                        ;
        }

}
