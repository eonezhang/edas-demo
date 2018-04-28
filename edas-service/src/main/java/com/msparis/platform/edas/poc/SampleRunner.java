package com.msparis.platform.edas.poc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author eonezhang 28/04/2018
 */
@Component
@RefreshScope
public class SampleRunner implements ApplicationRunner {
    @Value("${username}")
    String userId;
    @Value("${password}")
    String userName;

    @Override
    public void run(ApplicationArguments args) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("username:%s, password:%s\n", userId, userName);
            }
        }).start();
    }
}
