package com.aqqje.resetfulcrud.controller;

import com.aqqje.resetfulcrud.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


/*
    第一种：配置 templates 首页【抑制spring boot的自动加载index页面为首页】
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@PathParam("user") String user){

        if(user.equals("aaa")){
            throw new UserException();
        }
        return "Hello World!";
    }

    @RequestMapping("/success")
    //classpath:/templates/
    public String thymeleaf(Map<String, Object> map){
        map.put("hello", "<h1>你好<h1>");
        map.put("users", Arrays.asList("allen", "tom", "jack"));
        return "success";
    }
}
