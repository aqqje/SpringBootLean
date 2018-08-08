package com.aqqje.resetfulcrud.config;

import com.aqqje.resetfulcrud.component.LoginHandlerInterceptor;
import com.aqqje.resetfulcrud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  WebMvcConfigurerAdapter 过时
 *  使用1、WebMvcConfigurationSupport 2、WebMvcConfigurer可以来扩展SpringMVC的功能
 *  @EnableWebMvc 不要接管SpringMVC
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
    }




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/aqqje").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer config = new WebMvcConfigurer(){
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/", "login.html", "/index.html", "/user/login");
            }

            /**
             * 第一种：配置 templates 首页【抑制spring boot的自动加载index页面为首页】,
             * 必须加载到Spring Boot 容器中才可以生效
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");


            }
        };
        return config;
    }

    // 注册国际化解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
