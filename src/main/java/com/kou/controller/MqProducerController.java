package com.kou.controller;

import com.kou.service.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JIAJUN KOU
 */
@RestController
public class MqProducerController {

    @Autowired
    private MqProducerService mqTestService;

    @RequestMapping("/mqTest")
    public String test(String msg){
        mqTestService.sendMsg(msg);
        return "ok";
    }
    @GetMapping("/test")
    public String hello(){
        return "ok";
    }

}
