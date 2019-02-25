package com.zhf.why.configure;


import com.zhf.why.serviceImpl.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AfterStartRunner implements CommandLineRunner {

    @Autowired
    private SenderService senderService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------start-------------");
        Thread.sleep(2000L);
        // 测试广播模式
        senderService.broadcast("AfterStartRunner --> 同学们集合啦！");
        // 测试Direct模式
        senderService.direct("AfterStartRunner --> 定点消息");
    }
}
