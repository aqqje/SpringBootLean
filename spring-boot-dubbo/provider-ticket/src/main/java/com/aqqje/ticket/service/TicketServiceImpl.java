package com.aqqje.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public String ticket() {
        return "《厉害了，我的国》";
    }
}
