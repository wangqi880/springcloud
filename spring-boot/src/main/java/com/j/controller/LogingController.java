package com.j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogingController {

    @RequestMapping("/login")
    public String  login(){
        return "你还没有登录哦";
    }
}
