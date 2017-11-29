package com.j.controller;

import com.j.common.BaseResponse;
import com.j.common.CodeConstraint;
import com.j.model.User;
import com.j.model.UserRequest;
import com.j.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

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
        logger.info("调用成功");
        return response;
    }
    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/getInfo/{username}")
    public User getUser(@PathVariable String username) {
        User user = userService.getUserInfo(username);
        return user;
    }

}
