package com.longe.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskTwo extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.err.println("[TaskTwo] " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
