package com.example.shirodemo.service;

import com.example.shirodemo.mapper.UserMapper;
import com.example.shirodemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceTmpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name){
      return  userMapper.queryUserByName(name);
    }
}
