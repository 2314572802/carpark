package com.xfy.carpark.controller;

import com.xfy.carpark.util.CodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloKaptchaController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return "验证码有误！！！";
        } else {
            return "登录成功！欢迎使用！";
        }
    }
}
