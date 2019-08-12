package com.longe.Bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class Person {

    private String name;

    private int age;

    //这里规定格式，如果输出结果是规定的格式，说明使用的是fastjson转换器
    @JSONField(format = "yy-MM-dd")
    private Date birthDay;

    private List<String> list;
}
