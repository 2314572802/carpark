package com.xfy.carpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:mykaptcha.xml"})
public class CarparkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarparkApplication.class, args);
    }
}
