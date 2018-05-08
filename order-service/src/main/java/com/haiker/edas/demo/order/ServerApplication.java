package com.haiker.edas.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alibaba.dts.client.DtsClient;
import com.alibaba.edas.schedulerx.SchedulerXClient;
import com.taobao.pandora.boot.PandoraBootstrap;

/**
 * @author eonezhang 18/04/2018
 */
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        PandoraBootstrap.run(args);
//        ConfigCenter.initConfig();
        SpringApplication.run(ServerApplication.class, args);
        PandoraBootstrap.markStartupAndWait();
    }

    @Bean(initMethod = "init")
    public SchedulerXClient schedulerXClient() {
        SchedulerXClient bean = new SchedulerXClient();
        bean.setGroupId("101-1-2-4377");
        bean.setRegionName("cn-hangzhou");
//        bean.setGroupId("201-3-2-4378");
//        bean.setRegionName("cn-test");
        return bean;
    }

//    @Bean(initMethod = "init")
    public DtsClient dtsClient() {
        DtsClient bean = new DtsClient();
        bean.setGroupId("101-1-2-4377");
        bean.setRegionName("cn-hangzhou");
        return bean;
    }
}
