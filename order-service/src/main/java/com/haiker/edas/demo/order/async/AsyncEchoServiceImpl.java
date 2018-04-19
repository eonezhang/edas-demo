package com.haiker.edas.demo.order.async;

import com.alibaba.boot.hsf.annotation.HSFProvider;

/**
 * @author eonezhang 18/04/2018
 */
@HSFProvider(serviceInterface = AsyncEchoService.class, serviceVersion = "1.0.0")
public class AsyncEchoServiceImpl implements AsyncEchoService {
    @Override
    public String future(String string) {
        return string;
    }

    @Override
    public String callback(String string) {
        return string;
    }
}
