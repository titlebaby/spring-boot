package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//template 目录下的所有页面，只能通过controller 来访问
// 这个需要模板引擎的支持 thymeleaf
@Controller
public class IndexController {

    @RequestMapping({"/", "/index.html"}) // 这要配置是可以应用 index.html 但是没有css的样式
    public String index() {
//        return "index";
        return "auth-views/index";
    }

    //    使用视图解析器接接管 替代
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        model.addAttribute("msg", "hello world 123!");

        return "test";
    }
}
