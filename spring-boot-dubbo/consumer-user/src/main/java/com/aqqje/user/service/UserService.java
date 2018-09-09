package com.aqqje.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aqqje.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.ticket();
        System.out.println("买到票：" + ticket);
    }

}
