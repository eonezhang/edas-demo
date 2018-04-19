package com.haiker.edas.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haiker.edas.demo.EchoService;

/**
 * @author eonezhang 19/04/2018
 */
@RestController
public class SimpleController {
    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "/hsf-echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return echoService.echo(str);
    }
}
