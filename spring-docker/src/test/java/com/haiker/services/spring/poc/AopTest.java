package com.haiker.services.spring.poc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author eonezhang 04/05/2018
 */
public class AopTest {
    @Test
    public void aopTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        IAopBean bean = ctx.getBean(IAopBean.class);
        bean.methodToTest();
        ctx.close();
    }
}
