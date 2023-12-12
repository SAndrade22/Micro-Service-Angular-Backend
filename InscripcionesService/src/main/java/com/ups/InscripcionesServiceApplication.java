package com.ups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ups.model")
@EnableJpaRepositories(basePackages = "com.ups.repository")
public class InscripcionesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscripcionesServiceApplication.class, args);
    }
}

