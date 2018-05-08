package com.haiker.services.spring.poc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * @author eonezhang 04/05/2018
 */
@Service
@Transactional
@Slf4j
public class AopBean implements IAopBean {

    private AopBean target;

    @Override
    public void methodToTest() {
        log.info("methodToTest has been called");
    }
}
