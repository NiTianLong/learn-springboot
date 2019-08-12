package com.longe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//启动异步
@EnableAsync
@Configuration
public class AsyncTaskConfig {

    //设置Bean的名称不设置的话没有办法在 任务中对应 配置信息
    @Bean("asyncExecutor")
    public Executor taskExecutor() {
        //根据ThreadPoolTaskExecutor 创建建线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //为线程设置初始的线程数量 5条线程
        executor.setCorePoolSize(5);
        //为线程设置最大的线程数量 10条线程
        executor.setMaxPoolSize(10);
        //为任务队列设置最大 任务数量
        executor.setQueueCapacity(200);
        //设置 超出初始化线程的 存在时间为60秒
        //也就是 如果现有线程数超过5 则会对超出的空闲线程 设置摧毁时间 也就是60秒
        executor.setKeepAliveSeconds(60);
        //设置 线程前缀
        executor.setThreadNamePrefix("asyncExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置在关闭线程池时是否等待任务完成
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置等待线程任务完成的最长时间
        executor.setAwaitTerminationSeconds(60);
        //返回设置完成的线程池
        return executor;
    }

}
