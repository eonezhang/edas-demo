package com.haiker.services.spring.poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haiker.services.spring.poc.user.User;

/**
 * @author eonezhang 27/04/2018
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String index(User user) {
        return user.getUsername();
    }
}
