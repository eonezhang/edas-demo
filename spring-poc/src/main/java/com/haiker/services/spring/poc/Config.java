package com.haiker.services.spring.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @author eonezhang 27/04/2018
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class Config {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
