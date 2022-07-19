package com.example.shirodemo.config;

import com.example.shirodemo.pojo.User;
import com.example.shirodemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm  extends AuthorizingRealm {


    @Autowired
    UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了-权限检查=> 授权doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了-身份认证=> doGetAuthenticationInfo");
        // 数据库取数据 模拟
        String name = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //连接真实的数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {
            return null; // 抛出异常 UnknownAccountException
        }
//        if (!userToken.getUsername().equals(name)) {
//            return null; // 抛出异常 UnknownAccountException
//        }
        // 密码认证， shiro做
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("", user.getPwd(),"");

        return info;
    }
}
