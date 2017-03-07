package com.lista.config;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ceb on 30/04/16.
 */
@EntityScan(basePackages = "com.lista.model")
@EnableJpaRepositories(basePackages = "com.lista.repository")
@SpringBootApplication(scanBasePackages = "com.lista")
public class DatabaseApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}