package com.longe.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SpringScheduled {

    //@Scheduled(cron = "0/5 * * * * ?") 这里是使用的spring的定时任务
    public void testScheduled(){
        System.err.println("springScheduled run:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

}
