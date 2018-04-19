package com.haiker.edas.demo.user;

import org.springframework.context.annotation.Configuration;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import com.haiker.edas.demo.order.EchoService;
import com.haiker.edas.demo.order.async.AsyncEchoService;

/**
 * @author eonezhang 19/04/2018
 */
@Configuration
public class HSFConfig {
    @HSFConsumer(clientTimeout = 3000, serviceVersion = "1.0.0")
    private EchoService echoService;

    @HSFConsumer(clientTimeout = 3000, serviceVersion = "1.0.0", futureMethods = "future")
    private AsyncEchoService asyncEchoService;

}
