package com.briup.service;

import com.briup.bean.Student;

/**
 * java方法中 只要没有抛出异常对象表示成功
 *          抛出异常  表示失败 不同的异常对象或者信息
 * @Author lining
 * @Date 2022/10/4
 */
public interface IStudentService {
    //查询
    Student findStudentById(int id);
    //新增
    void addStudent();

    //修改
    void updateStudent();

    //删除
    void deleteStudent();
}
