package com.msparis.platform.edas.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eonezhang 28/04/2018
 */
@RestController
@RequestMapping("/sample")
@RefreshScope
public class SampleController {
    @Value("${username}")
    String userName;

    @RequestMapping("/acm")
    public String simple() {
        return "Hello Spring Cloud ACM!" + " Hello " + userName + "!";
    }
}
