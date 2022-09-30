package com.briup.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Data
@Component("c")
public class Course {
    @Value("101")
    private int id;
    @Value("java")
    private String name;
}
