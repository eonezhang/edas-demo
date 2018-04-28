package com.haiker.edas.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.haiker.edas.demo.order.components.ConfigCenter;
import com.taobao.pandora.boot.PandoraBootstrap;

/**
 * @author eonezhang 18/04/2018
 */
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        PandoraBootstrap.run(args);
        ConfigCenter.initConfig();
        SpringApplication.run(ServerApplication.class, args);
        PandoraBootstrap.markStartupAndWait();
    }
}
