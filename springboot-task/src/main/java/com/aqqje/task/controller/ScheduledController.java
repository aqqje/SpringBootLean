package com.aqqje.task.controller;

import com.aqqje.task.service.ScheduledSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledController {

    @Autowired
    ScheduledSerivce scheduledSerivce;

    @GetMapping("/schedule")
    public String schedule(){
        scheduledSerivce.schedule();
        return "success";
    }
}
