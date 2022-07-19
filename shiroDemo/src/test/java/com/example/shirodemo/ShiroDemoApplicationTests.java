package com.example.shirodemo;

import com.example.shirodemo.service.UserServiceTmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemoApplicationTests {
    @Autowired
    UserServiceTmpl userServiceTmpl;

    @Test
    void contextLoads() {
        System.out.println(userServiceTmpl.queryUserByName("ayi"));

    }

}
