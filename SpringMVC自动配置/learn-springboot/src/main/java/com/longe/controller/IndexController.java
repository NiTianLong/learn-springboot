package com.longe.controller;

import com.longe.Bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String index(){

        return "hello 消息转化器";
    }

    @RequestMapping("json")
    @ResponseBody
    public Person json(){

        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        person.setBirthDay(new Date());

        return person;
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){

        return "hello test";
    }
}
