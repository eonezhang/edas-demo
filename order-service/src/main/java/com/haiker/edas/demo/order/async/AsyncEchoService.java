package com.haiker.edas.demo.order.async;

/**
 * @author eonezhang 18/04/2018
 */
public interface AsyncEchoService {
    String future(String string);
    String callback(String string);
}

