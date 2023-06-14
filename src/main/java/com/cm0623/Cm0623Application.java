package com.cm0623;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Cm0623Application {

    public static void main(String[] args) {
        SpringApplication.run(Cm0623Application.class, args);
    }

}
