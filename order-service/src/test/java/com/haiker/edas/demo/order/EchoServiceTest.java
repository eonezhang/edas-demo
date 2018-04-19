package com.haiker.edas.demo.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import com.taobao.pandora.boot.test.junit4.DelegateTo;
import com.taobao.pandora.boot.test.junit4.PandoraBootRunner;

import junit.framework.TestCase;

/**
 * @author eonezhang 18/04/2018
 */
@RunWith(PandoraBootRunner.class)
@DelegateTo(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ServerApplication.class, EchoServiceTest.class })
@Component
public class EchoServiceTest {
    @HSFConsumer(generic = true)
    EchoService echoService;

    @Test
    public void testInvoke() {
        TestCase.assertEquals("Hello world", echoService.echo("Hello world"));
    }
}
