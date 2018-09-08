package com.aqqje.task.controller;


import com.aqqje.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;


    @GetMapping("/hello")
    public String asyncHello(){
        asyncService.hello();
        return "hello async";
    }
}
