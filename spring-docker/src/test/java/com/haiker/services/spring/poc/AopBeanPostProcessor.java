package com.haiker.services.spring.poc;

import java.lang.reflect.Field;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author eonezhang 04/05/2018
 */
@Slf4j
public class AopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(AopBean.class)) {
            log.info("{} is assignable from {}", bean.getClass().getName(), AopBean.class.getName());
        }
        if (AopUtils.isAopProxy(bean)) {
            Field field = ReflectionUtils.findField(AopUtils.getTargetClass(bean), "target");
            if (field != null) {
                field.setAccessible(true);
                Object target = null;
                if (AopUtils.isJdkDynamicProxy(bean)) {
                    try {
                        target = getJdkDynamicProxyTargetObject(bean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (AopUtils.isCglibProxy(bean)) {
                    try {
                        target = getCglibProxyTargetObject(bean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    field.set(target, new AopBean());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

        return bean;
    }

    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);

        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();

        return target;
    }

    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();

        return target;
    }
}
