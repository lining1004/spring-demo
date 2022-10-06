package com.briup.bean;

import lombok.Data;

/**
 * 对应的数据库表t_student
 * @Author lining
 * @Date 2022/10/6
 * mybatis逆向工程：根据表生成对应的类
 */
@Data
public class Student {
    private int id;//对应的列名
    private String name;
}
