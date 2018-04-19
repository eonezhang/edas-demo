package com.haiker.edas.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taobao.pandora.boot.PandoraBootstrap;

@SpringBootApplication
public class ConsumerApp {
    public static void main(String[] args) {
        PandoraBootstrap.run(args);
        SpringApplication.run(ConsumerApp.class, args);
        PandoraBootstrap.markStartupAndWait();
    }
}
