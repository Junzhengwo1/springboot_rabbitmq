package com.kou.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author JIAJUN KOU
 */
@Service
@RabbitListener(queues = "queue2")
public class MqConsumerService {

    @RabbitHandler
    public void receiveMsg(String msg){

        System.out.println("accept"+msg);
    }
}
