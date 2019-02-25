package com.zhf.why.configure;



import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 接收者
 */
@Component
public class Receiver {

    /**
     * FANOUT 广播队列监听一
     */
    @RabbitListener(queues = "FANOUT_QUEUE_A", containerFactory="rabbitListenerContainerFactory")
    public  void on(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

    /**
     * FANOUT 广播队列监听二
     */
    @RabbitListener(queues="FANOUT_QUEUE_B", containerFactory="rabbitListenerContainerFactory")
    public void t(Message message,Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

    /**
     * DIRECT 模式
     */
    @RabbitListener(queues = "DIRECT_QUEUE", containerFactory="rabbitListenerContainerFactory")
    public void message(Message message,Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
