package com.longe.config.extendmvc;

import com.longe.config.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 扩展springMVC
 */
@Configuration
//@EnableWebMvc 不推荐使用
public class ExtendSpringMVC implements WebMvcConfigurer{

    @Autowired
    MyInterceptor myInterceptor;

    /**
     * 添加一个拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }


    /**
     * 跨域相关
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //把http://localhost:8080/view 映射到 http://localhost:8080/success
        registry.addViewController("/view").setViewName("success");
    }
}
