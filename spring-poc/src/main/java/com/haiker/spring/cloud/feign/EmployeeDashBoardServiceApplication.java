package com.haiker.spring.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author eonezhang 04/05/2018
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EmployeeDashBoardServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeDashBoardServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
