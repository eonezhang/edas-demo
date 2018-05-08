package com.haiker.edas.demo.order.jobs;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.edas.schedulerx.ProcessResult;
import com.alibaba.edas.schedulerx.ScxSimpleJobContext;
import com.alibaba.edas.schedulerx.ScxSimpleJobProcessor;

/**
 * @author eonezhang 02/05/2018
 */
@Component
public class ExecuteShellJobProcessor implements ScxSimpleJobProcessor {
    private final Logger log = LoggerFactory.getLogger(ExecuteShellJobProcessor.class);

    @Override
    public ProcessResult process(ScxSimpleJobContext context) {
        log.info("Hello Scheduler {}", new Date());
        return new ProcessResult(true);
    }
}
