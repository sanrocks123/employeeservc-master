package com.paypal.bfs.employee.main;

import org.dizitart.no2.Nitrite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main entry class
 */

@EnableSwagger2
@SpringBootApplication(scanBasePackages = { "com" })
public class EmployeeservApplication {

    private static final Logger log = LoggerFactory.getLogger(EmployeeservApplication.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
        log.info("Service accessible at http://localhost:8080/swagger-ui.html");
    }

    /**
     *
     * @return
     */
    @Bean
    public Docket docket() {
        final Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
        return docket;
    }

    /**
     *
     * @return
     */
    @Bean
    public Nitrite initDB() {
        return Nitrite.builder().compressed().openOrCreate("user", "password");
    }

}