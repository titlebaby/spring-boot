package com.example.springboot01.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
/*    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控 配置 相当于 web.xml, servletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParameters = new HashMap<>();
        // 登陆的key， 是固定的 loginUsername loginPassword
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        // 允许谁可以访问
        initParameters.put("allow","localhost"); //所有人可以方法
        //禁止谁可以访问
//        initParameters.put("kangsheng","192.168.11.122");

        bean.setInitParameters(initParameters);//初始化参数
        return bean;
    }*/
}
