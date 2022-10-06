package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应的数据库表t_student
 * @Author lining
 * @Date 2022/10/6
 * mybatis逆向工程：根据表生成对应的类
 */
@Builder//建造者模式 主要用来简化set方法的调用
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;//对应的列名
    private String name;
}
