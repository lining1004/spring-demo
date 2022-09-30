package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("p3")
public class Person {
    @Value("1")
    private int id;
    @Value("rose")
    private String name;
}
