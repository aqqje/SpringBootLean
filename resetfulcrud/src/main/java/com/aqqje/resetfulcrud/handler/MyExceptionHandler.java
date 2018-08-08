package com.aqqje.resetfulcrud.handler;

import com.aqqje.resetfulcrud.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler  {

//    @ResponseBody
//    @ExceptionHandler(UserException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "aqqje");
//        map.put("message", "hello exception");
//        return map;
//    }
    @ExceptionHandler(UserException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 400);
        map.put("code", "aqqje");
        map.put("message", "hello exception");
        //转发到/error
        request.setAttribute("txt", map);
        return "forward:/error";
    }
}
