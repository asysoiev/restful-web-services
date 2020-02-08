package com.sandbox.rest.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

/**
 * @author Andrii Sysoiev
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration(exclude = {HypermediaAutoConfiguration.class})
public class SwaggerConfig {

    public static final Contact CONTACT = new Contact("Andrii Sysoiev", "", "andrii.sysoiev@gmail.com");
    private static final ApiInfo API_INFO = new ApiInfo("Sandbox web service", "RESTfull web service samples", "1.0", "urn:tos",
            CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList(APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .consumes(PRODUCES_AND_CONSUMES)
                .produces(PRODUCES_AND_CONSUMES)
                ;
    }

}
