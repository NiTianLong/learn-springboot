package com.longe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class IndexController {


    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        return null;
    }
}
