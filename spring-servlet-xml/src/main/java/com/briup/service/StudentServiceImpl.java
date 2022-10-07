package com.briup.service;

import com.briup.bean.Student;
import lombok.Data;


/**
 * @Author lining
 * @Date 2022/10/7
 *  //依赖于dao层方法 提供属性 dao对象
 */
@Data
public class StudentServiceImpl implements IStudentService {

    @Override
    public Student findStudentById(int id) {
        return new Student(id,"tom");
    }

    @Override
    public void addStudent(Student s) {

    }

    @Override
    public void updateStudent(Student s) {

    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void deleteStudents(int... id) {

    }
}
