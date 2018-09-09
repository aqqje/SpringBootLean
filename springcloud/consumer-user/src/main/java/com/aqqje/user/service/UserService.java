package com.aqqje.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String ticket(){
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return s;
    }
}
