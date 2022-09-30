package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author lining
 * @Date 2022/9/29
 */
@NoArgsConstructor//set注入
@AllArgsConstructor//可以选择构造器注入
@Data
public class Person {
    private String[] arr;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties props;// java配置对象 k=v文件
    private List<Student> students;
}
