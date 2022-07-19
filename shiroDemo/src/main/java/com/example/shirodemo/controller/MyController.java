package com.example.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MyController {
    @RequestMapping({"/", "/index"})
//    @RequestMapping("/index")
    public String toIndex(Model model) {

        model.addAttribute("msg", "hello shiro");
        return "index";

    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password , Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        subject.login(token);
        try {
            subject.login(token); // 如果没有异常就成功
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误");
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg","其他错误");
            return "login";
        }
    }

}
