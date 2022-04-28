package com.xfy.carpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ImportResource(locations = {"classpath:mykaptcha.xml"})
public class CarparkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarparkApplication.class, args);
    }
}
