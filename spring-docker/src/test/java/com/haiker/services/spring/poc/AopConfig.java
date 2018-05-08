package com.haiker.services.spring.poc;

import org.aopalliance.intercept.Interceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author eonezhang 04/05/2018
 */
@Configurable
public class AopConfig {

    @Bean
    public IAopBean aopBean() {
        Interceptor interceptor = new DebugInterceptor();
        ProxyFactory proxyFactory = new ProxyFactory(IAopBean.class, interceptor);
        proxyFactory.setTarget(new AopBean());
        return (IAopBean) proxyFactory.getProxy();
    }

    @Bean
    public AopBeanPostProcessor postProcessor() {
        return new AopBeanPostProcessor();
    }
}
