package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//template 目录下的所有页面，只能通过controller 来访问
// 这个需要模板引擎的支持 thymeleaf
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("users", Arrays.asList("zhangsan","lisi","wangwu"));
        model.addAttribute("msg","hello world 123!");

        return "test";
    }
}
