package com.haiker.services.acm;

import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.edas.acm.ConfigService;
import com.alibaba.edas.acm.exception.ConfigException;
import com.alibaba.edas.acm.listener.ConfigChangeListener;

/**
 * @author eonezhang 26/04/2018
 */
public class AcmTest {
    // 属性/开关
    private static String config = "DefaultValue";

    @Test
    @Ignore
    public void acmInit() throws ConfigException, InterruptedException {
        Properties properties = new Properties();
        properties.put("endpoint", "acm.aliyun.com");
        properties.put("namespace", "****");
        properties.put("accessKey", "****");
        properties.put("secretKey", "***");
//        properties.put("accessKey", "d685a49fa704448884007a49b6efca93");
//        properties.put("secretKey", "DqIlQE/vyuwlfoMOe8/XiVAvzKk=");

        ConfigService.init(properties);
        // Get configuration proactively
        String content = ConfigService.getConfig("application", "com.msparis.order.service", 6000);
        System.out.println(content);
        // Add listener for the configuration during initialization, so that configuration changes will trigger callback notifications.
        ConfigService.addListener("application", "com.msparis.order.service", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                // When the configuration is updated, the callback function will send the new value to the user.
                // Note that you should not perform any block operations in the callback function. Otherwise the thread will be blocked.
                config = configInfo;
                System.out.println(configInfo);
            }
        });

        Thread.sleep(50000000000L);
    }
}
