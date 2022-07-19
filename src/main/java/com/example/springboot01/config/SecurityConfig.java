package com.example.springboot01.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        //首页所有人可以访问，功能也只有对应权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/auth_index").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // aop 切面编程
        // 没有权限默认要到登陆页
        http.formLogin()
                // 指定登陆界面，没有就是默认的登陆界面
                .loginPage("/toLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                // 指定验证用户名和密码的地址
                .loginProcessingUrl("/login");


        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember"); //cookie
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
//        auth.jdbcAuthentication(); 到数据库认证
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lili").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
