package com.example.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 牢记：
 * 1. WebSecurityConfigurerAdapter : 自定义Security策略
 * 2. AuthenticationManagerBuilder： 自定义认证策略
 * 3. EnableWebSecurity： 开启WwbSecurity 模式。 @EnableXXXX开启某个功能
 *
 */
@Controller
public class AuthRouterController {

//    @RequestMapping({"/", "/index"})
    @RequestMapping("/auth_index")
    public String index() {
        return "auth-views/index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "auth-views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "auth-views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "auth-views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "auth-views/level3/" + id;

    }
}
