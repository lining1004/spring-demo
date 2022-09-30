package com.briup.config;

import com.briup.bean.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 普通类
 * @Author lining
 * @Date 2022/9/30
 */
public class GroupConfig {
    @Bean
    public Group group(){
        return new Group();
    }
}
