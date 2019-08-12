package com.longe.config;

import com.longe.task.TaskOne;
import com.longe.task.TaskTwo;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class quartzConfig {

    // 使用jobDetail包装job(即要执行的定时任务)
    @Bean
    public JobDetail taskOneJobDetail() {
        return JobBuilder.newJob(TaskOne.class).withIdentity("taskOneJob").storeDurably().build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger taskOneJobDetailTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(taskOneJobDetail())
                .withIdentity("taskOneJobDetailTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    // 使用jobDetail包装job(即要执行的定时任务)
    @Bean
    public JobDetail taskTwoJobDetail() {
        return JobBuilder.newJob(TaskTwo.class).withIdentity("taskTwoJob").storeDurably().build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger taskTwoJobDetailTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(taskTwoJobDetail())
                .withIdentity("taskTwoJobDetailTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
