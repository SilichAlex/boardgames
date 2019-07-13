package com.boardgames.thethingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThethingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThethingServiceApplication.class, args);
    }

}
