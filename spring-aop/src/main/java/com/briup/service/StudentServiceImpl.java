package com.briup.service;

import com.briup.aop.Logging;
import com.briup.aop.Role;
import com.briup.bean.Student;
import org.springframework.stereotype.Service;

/**
 * 目标类 目标对象 连接点：目标类中所有的非final修饰的方法
 * @Author lining
 * @Date 2022/10/4
 */
@Service //<bean> 创建一个目标对象
public class StudentServiceImpl implements IStudentService{


    //连接点
    @Logging  //添加通知代码
    @Role //每次执行方法前织入权限验证代码，进行身份验证
    public Student findStudentById(int id) {
        System.out.println("查询学生信息");
        //当切入点发生异常时,观察对后置通知的影响
        System.out.println(1/0);
        return new Student(1,"jack");
    }

    //@Logging//连接点
    public void addStudent() {
        System.out.println("添加学生信息");
    }

    @Override//连接点
    public void updateStudent() {
        System.out.println("更新学生信息");
    }

    @Override//连接点
    public void deleteStudent() {
        System.out.println("删除学生信息");
    }
}
