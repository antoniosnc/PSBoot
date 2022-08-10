package com.udemy.serviceitemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
//@RibbonClient(name = "spring-boot-producto")
@EnableFeignClients
@SpringBootApplication
public class ServiceItemPApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceItemPApplication.class, args);
    }

}
