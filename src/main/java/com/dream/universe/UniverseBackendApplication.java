package com.dream.universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class UniverseBackendApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "classpath:aws.yml";


    public static void main(String[] args) {
        new SpringApplicationBuilder(UniverseBackendApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
