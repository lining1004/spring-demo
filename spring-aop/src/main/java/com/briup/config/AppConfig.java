package com.briup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author lining
 * @Date 2022/10/5
 */
@Configuration
@ComponentScan(basePackages = "com.briup")
@EnableAspectJAutoProxy //基于aop注解
public class AppConfig {
    //1.创建service层目标对象
}
