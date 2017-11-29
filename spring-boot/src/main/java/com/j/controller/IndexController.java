package com.j.controller;

import com.j.common.BaseResponse;
import com.j.common.CodeConstraint;
import com.j.model.User;
import com.j.model.UserRequest;
import com.j.service.UserService;
import com.sun.org.apache.bcel.internal.util.InstructionFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {


    @Autowired
    UserService userService;

    @RequestMapping
    public String index(){
        return "hello";
    }

    @RequestMapping(value = "/get")
    public Object get(@Valid @ModelAttribute UserRequest userRequest, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        User user = new User();
        user.setUsername(userRequest.getUsername());
        response.setCode(CodeConstraint.SUCCESS);
        response.setInfo("success");
        response.setData(user);

        return response;
    }
    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/getInfo/{username}")
    public User getUser(@PathVariable String username) {
        User user = userService.getUserInfo(username);
        return user;
    }

}
