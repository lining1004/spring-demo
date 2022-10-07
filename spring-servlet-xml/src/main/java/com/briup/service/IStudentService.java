package com.briup.service;

import com.briup.bean.Student;

/**
 * @Author lining
 * @Date 2022/10/7
 */
public interface IStudentService {
    Student findStudentById(int id);
    void addStudent(Student s);
    void updateStudent(Student s);
    void deleteStudent(int id);
    void deleteStudents(int... id);
}
