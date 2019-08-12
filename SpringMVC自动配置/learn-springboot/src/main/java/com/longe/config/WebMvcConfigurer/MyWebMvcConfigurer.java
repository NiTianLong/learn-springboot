package com.longe.config.WebMvcConfigurer;

import com.longe.config.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer {

    @Autowired
    MyInterceptor myInterceptor;

    //添加bean注解，注入到容器中
    @Bean
    public WebMvcConfigurer setWebMvcConfigurer(){

        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/view").setViewName("success");
                registry.addViewController("/page").setViewName("success");
                registry.addViewController("/goods").setViewName("success");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(myInterceptor).addPathPatterns("/**")
                        .excludePathPatterns("/user/login","/user/register");
            }
        };

        return webMvcConfigurer;
    }
}
