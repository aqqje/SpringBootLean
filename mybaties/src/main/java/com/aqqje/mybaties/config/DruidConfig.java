package com.aqqje.mybaties.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DruidConfig {

    /**
     *  注册druid数据源
     * @return DruidDataSource
     */

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * druid 后台服务
     * @return bean
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean =
                new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "yjgm");
        initParameters.put("loginPassword", "520");
        initParameters.put("allow", "");
        initParameters.put("deny", "192.168.101.1");

        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * druid web filter
     * @return bean
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*,js,*css,/druid/*");

        bean.setInitParameters(initParameters);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
