package com.haiker.edas.demo.order;

import com.alibaba.boot.hsf.annotation.HSFProvider;

/**
 * @author eonezhang 18/04/2018
 */
@HSFProvider(serviceInterface = EchoService.class, serviceVersion = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String string) {
        return string;
    }
}
