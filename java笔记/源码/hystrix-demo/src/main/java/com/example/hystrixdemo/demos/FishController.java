package com.example.hystrixdemo.demos;

import com.example.hystrixdemo.MyFish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SeaBreeze
 * @version 1.0
 * @description: TODO
 * @date 2023/4/7 8:40
 */

@RestController
public class FishController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("doRpc")
    @MyFish
    public String test(){
        return "niha";
    }
}
