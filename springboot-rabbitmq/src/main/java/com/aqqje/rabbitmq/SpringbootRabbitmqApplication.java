package com.aqqje.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * rabbitMq自动配置类：RabbitAutoConfiguration
 *  1.CachingConnectionFactory：自动配置的连接工厂
 *  2.RabbitTemplate：关于 rabbitMq 消息的发送和接收
 *  3.AmqpAdmin：RabbitMQ系统管理功能组件;
 *      创建和删除 Queue，Exchange，Binding
 */

@EnableRabbit // 基于注解开启rabbit模式
@SpringBootApplication
public class SpringbootRabbitmqApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }
}
