package com.briup.service;

import com.briup.bean.Student;
import org.springframework.stereotype.Service;

/**
 * @Author lining
 * @Date 2022/10/10
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Override
    public void addStudent(Student s) {
        //控制台直接打印乱码：控制台和tomcat编码不统一
        System.out.println("插入学生信息："+s);
    }
}
