package com.longe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling 使用spring的定时任务时，需要配置
public class LearnSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringbootApplication.class, args);
	}

}
