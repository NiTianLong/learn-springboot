package com.longe.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;

    @Override
    public String toString() {
        return "PersonOne{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }
}