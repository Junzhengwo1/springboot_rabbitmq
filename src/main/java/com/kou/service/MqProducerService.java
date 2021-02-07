package com.kou.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JIAJUN KOU
 */
@Service
public class MqProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String msg){

        if(msg.startsWith("a")){
            //发送消息到队列
            amqpTemplate.convertAndSend("queue2",msg);
        }else if(msg.startsWith("b")){
            //发送消息到交换机
            amqpTemplate.convertAndSend("ex1","",msg);
        }else if(msg.startsWith("c_")){
            //发送消息到路由交换机
            if(msg.startsWith("c_a")){
                amqpTemplate.convertAndSend("ex2","a",msg);
            }else if(msg.startsWith("c_b")){
                amqpTemplate.convertAndSend("ex2","b",msg);

            }
        }
    }

}
