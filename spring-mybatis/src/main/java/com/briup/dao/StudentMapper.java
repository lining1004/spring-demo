package com.briup.dao;

import com.briup.bean.Student;
import org.springframework.stereotype.Component;

/**
 * 映射接口
 * @Author lining
 * @Date 2022/10/6
 */
public interface StudentMapper {
    // id name age address 多条件查询 findStudentByCondition
    Student findStudentById(int id);
}
