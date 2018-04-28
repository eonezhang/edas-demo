package com.msparis.platform.edas.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author eonezhang 28/04/2018
 */
@SpringBootApplication
public class EdasPocApp {
    public static void main(String[] args) {
//        PandoraBootstrap.run(args);
        SpringApplication.run(EdasPocApp.class, args);
//        PandoraBootstrap.markStartupAndWait();
    }
}
