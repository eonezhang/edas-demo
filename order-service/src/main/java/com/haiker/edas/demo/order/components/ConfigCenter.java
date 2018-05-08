//package com.haiker.edas.demo.order.components;
//
//import com.alibaba.edas.configcenter.config.ConfigChangeListener;
//import com.alibaba.edas.configcenter.config.ConfigService;
//
///**
// * @author eonezhang 26/04/2018
// */
//public class ConfigCenter {
//    private static String config = "";
//
//    public static void initConfig() {
//
//        String dataId = "application";
//        String group = "order-service";
//        ConfigService.addListener(dataId, group, new ConfigChangeListener() {
//           public void receiveConfigInfo(String configInfo) {
//               config = configInfo;
//               System.out.printf("configInfo: %s\n", configInfo);
//           }
//        });
//    }
//}
