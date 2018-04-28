package com.haiker.services.spring.poc.user;

/**
 * @author eonezhang 27/04/2018
 */
public class User {
    private final String username;
    private final String id;

    public User(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}
