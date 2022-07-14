package com.example.springboot01.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");

        Locale locale = Locale.getDefault();
        // 参照 AcceptHeaderLocaleResolver 类
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
             locale = new Locale(split[0], split[1]);
            System.out.println("debug=> l="+l);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
