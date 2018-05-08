package com.haiker.edas.demo.order.jobs;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dts.client.executor.grid.processor.GridJobContext;
import com.alibaba.dts.client.executor.job.processor.GridJobProcessor;
import com.alibaba.dts.common.domain.result.ProcessResult;

/**
 * @author eonezhang 02/05/2018
 */
public class HelloGridJobProcessor implements GridJobProcessor {
    @Override
    public ProcessResult process(GridJobContext context) throws Exception {
        String taskName = context.getTaskName();
        if ("root_level_task_name".equals(taskName)) {
            context.dispatchTaskList(buildDataSmall(context), "first-level-task");
            return new ProcessResult(true);
        }
        return null;
    }

    private List<? extends Object> buildDataSmall(GridJobContext context) {
        int count = 1000;
        List<Integer> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(i);
        }
        return data;
    }
}
