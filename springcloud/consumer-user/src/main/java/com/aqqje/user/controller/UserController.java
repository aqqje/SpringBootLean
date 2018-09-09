package com.aqqje.user.controller;

import com.aqqje.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/buy")
    public String buy(@PathParam("name") String name){
        String ticket = userService.ticket();
        return name + "购票：" + ticket;
    }
}
