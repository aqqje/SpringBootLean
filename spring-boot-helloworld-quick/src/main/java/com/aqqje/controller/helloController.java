package com.aqqje.controller;

import com.aqqje.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class helloController {

    @Value("#{person.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World quick!" + name;
    }
}
