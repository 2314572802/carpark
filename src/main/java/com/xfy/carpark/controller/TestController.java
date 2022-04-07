package com.xfy.carpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/TestController")
    public @ResponseBody String test(){
        return "test success";
    }
}
