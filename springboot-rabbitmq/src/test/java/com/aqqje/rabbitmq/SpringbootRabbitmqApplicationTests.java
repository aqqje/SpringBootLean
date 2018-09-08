package com.aqqje.rabbitmq;

import com.aqqje.rabbitmq.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
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

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 测试 AmqpAdmin 对rabbitmq的 exchanges, queues, binding
     */
    @Test
    public void testamqpAdmin(){
        // 创建一个交换器
        //amqpAdmin.declareExchange(new DirectExchange("aqqje.direct", true, false));
        //amqpAdmin.declareExchange(new FanoutExchange("aqqje.fanout", true, false));
        //amqpAdmin.declareExchange(new TopicExchange("aqqje.topic", true, false));
        // 创建消息队列
        //amqpAdmin.declareQueue(new Queue("aqqje.emps", true));
        //amqpAdmin.declareQueue(new Queue("aqqje.news", true));
        //amqpAdmin.declareQueue(new Queue("aqqje", true));
        // 为交换器绑定消息队列
        //amqpAdmin.declareBinding(new Binding("aqqje.emps", Binding.DestinationType.QUEUE, "aqqje.direct", "aqqje.emps", null));
        //amqpAdmin.declareBinding(new Binding("aqqje.news", Binding.DestinationType.QUEUE, "aqqje.fanout", "aqqje.news", null));
        //amqpAdmin.declareBinding(new Binding("aqqje", Binding.DestinationType.QUEUE, "aqqje.topic", "aqqje.#", null));
        //amqpAdmin.declareBinding(new Binding("aqqje.emps", Binding.DestinationType.QUEUE, "aqqje.topic", "aqqje.#", null));
        //amqpAdmin.declareBinding(new Binding("aqqje.news", Binding.DestinationType.QUEUE, "aqqje.topic", "aqqje.#", null));
        //amqpAdmin.declareBinding(new Binding("aqqje.news", Binding.DestinationType.QUEUE, "aqqje.topic", "*.aqqje", null));

        //System.out.println("创建完成！");

        // 删除指定的交换器和消息队列
        //amqpAdmin.deleteExchange("aqqje.fanout");
        //amqpAdmin.deleteQueue("aqqje.news");
    }

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
        rabbitTemplate.convertAndSend("aqqje.emps","aqqje.emps", map);
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

