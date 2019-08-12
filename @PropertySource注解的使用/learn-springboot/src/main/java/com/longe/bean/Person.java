package com.longe.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Data
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }
}