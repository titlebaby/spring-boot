package com.example.springboot01.controller;

import com.example.springboot01.mapper.UserMapper;
import com.example.springboot01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisUserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public  List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        return users;
    }


    @GetMapping("/addUserList")
    public String addUserList(){
        userMapper.addUser(new User(2,"ayi","123654"));
        return "ok";
    }

    @GetMapping("/updateUserList")
    public  String updateUserList(){
        userMapper.updateUser(new User(1,"ayi111","123654"));
        return "ok";
    }

    @GetMapping("/deleteUserList")
    public String deleteUserList(){
         userMapper.deleteUser(1);
        return "ok";
    }


}
