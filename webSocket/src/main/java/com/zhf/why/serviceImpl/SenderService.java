package com.zhf.why.serviceImpl;


import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class SenderService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试广播模式.
     */
    public void broadcast(String p){
        System.out.println(p);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", p, correlationData);
    }

    /**
     *  测试Direct模式.
     */
    public void direct(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY", p, correlationData);
    }

}
