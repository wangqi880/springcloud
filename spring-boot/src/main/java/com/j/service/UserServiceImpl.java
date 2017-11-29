package com.j.service;

import com.j.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public User getUserInfo(String username){

        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        return user;
    }
}
