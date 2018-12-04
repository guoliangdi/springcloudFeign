package com.springcloud.eurekaprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoliangDi
 * @Title: ProviderController
 * @Description: TODO
 * @date 2018/11/23下午2:41
 */

@RestController
public class ProviderController {

    @GetMapping("/hello")
    public String gethello(){

        return "this is jenkins ci print.. exe update shell(33333333);";
    }
}
