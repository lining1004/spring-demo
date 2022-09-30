package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author lining
 * @Date 2022/9/29
 */
@NoArgsConstructor //无参构造器 spring自动调用
@AllArgsConstructor
@Data
public class Teacher {
    private int id;
    private String name;
    private Student stu;
}
