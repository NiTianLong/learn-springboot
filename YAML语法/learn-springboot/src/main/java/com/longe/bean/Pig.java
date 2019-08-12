package com.longe.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pig {

    @Value("${name1}")
    private String name1;
    @Value("${name2}")
    private String name2;
    @Value("${name3}")
    private String name3;

    @Override
    public String toString() {
        return "Pig{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                '}';
    }
}
