package com.zhf.why.configure;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitConfig {

    @Resource
    private RabbitTemplate  rabbitTemplate;

    /**
     *
     * @return
     */
    @Bean
    public AmqpTemplate amqpTemplate(){
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        //消息发送失败返回到队列中,yml需要配置 publisher-returns:true
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message,replyCode,replyText,exChange,routingKey)->{
                String corrlationId = message.getMessageProperties().getCorrelationId();
        });
        //消息确认,yml需要配置 publisher-config ture
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (ack){
                System.out.println("消息发送到exchange成功");
            }else{
                System.out.println("消息发送到exchange失败");
            }
        }));
        return rabbitTemplate;
    }

    /**
     * 声明Direct交换机 支持持久化
     */
    @Bean("directExchange")
    public Exchange direcExchange(){
        return ExchangeBuilder.directExchange("DIRECT_EXCHANGE").durable(true).build();
    }

    /**
     * 声明一个队列,支持持久化
     */
    @Bean("directQueue")
    public Queue directQueue(){
        return QueueBuilder.durable("DIRECT_QUEUE").build();
    }

    /**
     * 通过绑定键 将指定队列绑定到一个指定的交换机
     */
    @Bean
    public Binding directBinding(@Qualifier("directQueue") Queue queue,
                                 @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("DIRECT_ROUTING_KEY").noargs();
    }

    /* ----------------------------------------------------------------------------Fanout exchange test--------------------------------------------------------------------------- */

    /**
     * 声明 fanout 交换机.
     *
     * @return the exchange
     */
    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange("FANOUT_EXCHANGE").durable(true).build();
    }

    /**
     * Fanout queue A.
     *
     * @return the queue
     */
    @Bean("fanoutQueueA")
    public Queue fanoutQueueA() {
        return QueueBuilder.durable("FANOUT_QUEUE_A").build();
    }

    /**
     * Fanout queue B .
     *
     * @return the queue
     */
    @Bean("fanoutQueueB")
    public Queue fanoutQueueB() {
        return QueueBuilder.durable("FANOUT_QUEUE_B").build();
    }

    /**
     * 绑定队列A 到Fanout 交换机.
     *
     * @param queue          the queue
     * @param fanoutExchange the fanout exchange
     * @return the binding
     */
    @Bean
    public Binding bindingA(@Qualifier("fanoutQueueA") Queue queue,
                            @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    /**
     * 绑定队列B 到Fanout 交换机.
     *
     * @param queue          the queue
     * @param fanoutExchange the fanout exchange
     * @return the binding
     */
    @Bean
    public Binding bindingB(@Qualifier("fanoutQueueB") Queue queue,
                            @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
