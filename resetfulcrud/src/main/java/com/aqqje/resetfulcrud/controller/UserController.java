package com.aqqje.resetfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    // 用户登录检验
    @PostMapping(value="/user/login")
    public String UserLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Map<String, Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            // 成功
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            // 错误
            map.put("msg", "用户名或密码错误！");
            return "/login.html";

        }
    }
}
