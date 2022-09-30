package com.briup.bean;

/**
 * 工厂类： 创建指定Student类型的对象
 * 复习：
 * SqlSessionFactroyBuilder-->SqlSessionFactory --->SqlSession-->Mapper
 * 什么时候需要提供工厂类代码？？？
 * 当对象的创建比较复杂的时候，提供工程类封装创建过程。
 * @Author lining
 * @Date 2022/9/29
 */
public class StudentFactory {
    //静态方法 非静态方法
    public Student getStudent(){
        //创建对象提供其他判断逻辑，对象赋值
        return new Student(2,"tom");
    }

}
