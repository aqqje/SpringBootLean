package com.aqqje.resetfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("person", "aqqje");
        map.put("wife", "yjgm");

        Map<String, Object> txt = (Map<String, Object>) webRequest.getAttribute("txt", 0);
        map.put("txt", txt);
        return map;
    }
}
