package com.example.shirodemo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    //3 ShiroFilterFactoryBean 过滤对象
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
       //设置安全管理器
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器

        /**
         *  anon : 无需认证
         *  authc : 必须认证才能访问
         *  user ： 必须拥有 记住我 功能才能用
         *  perms : 拥有对某个资源的权限才能访问
         *  role ： 拥有某个角色全才能访问
         *   filterMap.put("/user/*", "authc");
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/add", "authc");
        filterMap.put("/update", "authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        factoryBean.setLoginUrl("/toLogin");
        return factoryBean;
    }


    // 2. DefaultWebSecurityManager  安全对象
    // Qualifier 绑定方法名
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //1.创建一个realm对象，需要自定义类：1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
