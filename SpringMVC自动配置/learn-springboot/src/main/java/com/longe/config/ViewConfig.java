package com.longe.config;

import com.longe.config.view.MyViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ViewConfig {

    @Bean
    public MyViewResolver getViewResolver(){

        return new MyViewResolver();
    }
}
