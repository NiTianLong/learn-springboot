package com.longe.config.httpmessageconvert;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义fastJson消息转换器
 */
//@Configuration
public class FastJsonMessageConvert implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastjson转化器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        //媒体
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//解决中文乱码
        supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        supportedMediaTypes.add(new MediaType("text", "json", Charset.forName("UTF-8")));
        supportedMediaTypes.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        supportedMediaTypes.add(new MediaType("text", "html", Charset.forName("UTF-8")));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);

        //创建fastjson的配置对象
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //对json数据进行格式化
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                //List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //Boolean字段如果为null,输出为falseJ,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.DisableCircularReferenceDetect,
                //是否输出值为null的字段,默认为false。
                SerializerFeature.WriteMapNullValue
        );

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //把该转换器加入转化器容器集合中
        converters.add(fastJsonHttpMessageConverter);
    }
}
