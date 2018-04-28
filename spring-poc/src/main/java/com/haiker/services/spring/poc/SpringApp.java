package com.haiker.services.spring.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

/**
 * @author eonezhang 27/04/2018
 */
@SpringBootApplication
public class SpringApp {

    @Value("${PID}")
    private Long pid;

    @Bean
    public ApplicationRunner applicationRunner(ConfigurableApplicationContext ctx) {
        return args ->  {
            Environment env = ctx.getEnvironment();
            MutablePropertySources propsSources = ctx.getEnvironment().getPropertySources();
            Long pid = this.pid;

            System.out.printf("%s\n", args);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
