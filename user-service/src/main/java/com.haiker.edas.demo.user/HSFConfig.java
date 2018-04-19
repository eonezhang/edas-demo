package com.haiker.edas.demo.consumer;

import org.springframework.context.annotation.Configuration;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import com.haiker.edas.demo.EchoService;
import com.haiker.edas.demo.async.AsyncEchoService;

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
