package com.springcloud.eurekaconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author GuoliangDi
 * @Title: UserConsumer
 * @Description: TODO
 * @date 2018/11/23下午2:45
 */

@FeignClient("eureka-provider")//配置服务提供者实例名称
public interface UserConsumer {

    /**
     * 服务提供者路由
     * @return
     */
    @GetMapping("/hello")
    String gethello();
}
