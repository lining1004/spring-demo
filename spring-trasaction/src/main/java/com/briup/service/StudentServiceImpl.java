package com.briup.service;

import com.briup.bean.Student;
import com.briup.dao.StudentDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author lining
 * @Date 2022/10/7
 *  //依赖于dao层方法 提供属性 dao对象
 */
@Data
@Service //new StudentServiceImpl()
@Transactional
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public Student findStudentById(int id) {
        return dao.selectStudentById(id);
    }

    @Override
    public void addStudent(Student s) {

    }

    @Override
    public void updateStudent(Student s) {

    }
    /*
      <tx:method name="*" propagation="REQUIRED" rollback-for="Exception" />
        注解所在的方法开始事务管理
        事务传播 ： 使用同一个事务

     */
    //@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//对该方法开始事务管理 <tx:method >
    public void deleteStudent(int id) {
        dao.deleteStudentById(id);
        /*
          其他的非dao层的操作： 发短信 其他逻辑判断
           当service方法执行过程中抛出异常；要求所有事务操作都进行回滚

         */
         throw new RuntimeException("模拟其他语法异常");



    }

    /**
     * 删除多个学生事务
     * 1.同时成功或者
     * 同时失败:当异常发生时，将异常发生的事务自动提交。异常后的代码未执行。
     * @param id
     */
    @Override //
    public void deleteStudents(int... id) {
        //1.遍历id数组。
        //2.多次删除方法
        //开始事务1：
        dao.deleteStudentById(id[0]);//id=1
        if(1==1){
            throw new RuntimeException("模拟SQLException异常");
        }
        dao.deleteStudentById(id[1]);//id=2
        dao.deleteStudentById(id[2]);//id=3
        //......
        //提交事务：
    }
}
