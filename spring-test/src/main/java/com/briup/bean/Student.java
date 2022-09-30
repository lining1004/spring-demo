package com.briup.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Data
@Component  //4个组件注解 通用组件
public class Student {
    @Value("1")
    private int id;
    @Value("jack")
    private String name;
}
