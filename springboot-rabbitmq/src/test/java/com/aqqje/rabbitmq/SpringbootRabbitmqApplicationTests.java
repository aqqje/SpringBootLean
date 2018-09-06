package com.aqqje.rabbitmq;

import com.aqqje.rabbitmq.comfig.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {


    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 单播(点对点)
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "This first messages");
        map.put("data", "Hello Word");
        map.put("flag", true);
        rabbitTemplate.convertAndSend("exchange.direct","aqqje.news", map);
    }

    /**
     * 接收消息
     */
    @Test
    public void receive(){
        Object book = rabbitTemplate.receiveAndConvert("aqqje");
        System.out.println(book.getClass());
        System.out.println(book);

    }

    /**
     * 广播
     */

    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("aqqje", 100));
    }
}
