package com.udemy.serviceproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServiceProductoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductoApplication.class, args);
    }

}
