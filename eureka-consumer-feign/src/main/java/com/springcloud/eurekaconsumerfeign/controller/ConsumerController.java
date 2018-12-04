package com.springcloud.eurekaconsumerfeign.controller;

import com.netflix.discovery.converters.Auto;
import com.springcloud.eurekaconsumerfeign.service.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoliangDi
 * @Title: ConsumerController
 * @Description: TODO
 * @date 2018/11/23下午2:43
 */
@RestController
public class ConsumerController {

    @Autowired
    private UserConsumer userConsumer;


    @GetMapping("/hello")
    public String helloClient() {

        String v = userConsumer.gethello();
        return v;
    }
}
