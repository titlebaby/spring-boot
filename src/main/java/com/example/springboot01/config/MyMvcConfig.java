package com.example.springboot01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
class MyMvcConfigurer implements WebMvcConfigurer {

}
/*
package com.example.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
// 如果我们要扩展springmvc ，官方建议我们这样来做，新建xxxxConfig ，需要标注 @Configuration
// 如果 像div 一些定制的功能，只要写一个组件，然后将它交给springboot （组件化） springboot就会帮我们自动装配
//扩展 springmvc  DispatcherServlet
@Configuration
@EnableWebMvc //实际是导入了DelegatingWebMvcConfiguration并且继承了WebMvcConfigurationSupport， mvc配置要生效必须没有这个类 WebMvcConfigurationSupport
public class MyMvcConfig implements WebMvcConfigurer {
    //ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
    // 就自己定义的视图组件化
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

   public static class MyViewResolver implements ViewResolver{
       @Override
       public View resolveViewName(String viewName, Locale locale){
           return null;
       }
   }
    @Override
   public void addViewControllers(ViewControllerRegistry register){
        register.addViewController("/kuang").setViewName("index");
   }

   //alt + insert 可以重写很多方法

}
 */
