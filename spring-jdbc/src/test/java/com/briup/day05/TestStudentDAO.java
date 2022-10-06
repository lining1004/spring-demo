package com.briup.day05;

import com.briup.bean.Student;
import com.briup.dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author lining
 * @Date 2022/10/6
 */
public class TestStudentDAO {
    @Test
    public void service(){
        //1.读取配置文件,获取ioc容器对象
        ApplicationContext container = new ClassPathXmlApplicationContext("jdbc.xml");
        //2.获取dao对象
        StudentDao dao = container.getBean(StudentDao.class);
        //3.调用方法实现数据库的操作
        Student s = dao.findStudentById(1);
        System.out.println("查询："+s);
        int num = dao.findStudentCount();
        System.out.println("学生数量："+num);
        List<Student> list = dao.findAllStudent();
        System.out.println("所有学生:"+list);
/*        Student s2 = Student.builder().id(6).name("tom").build();
        dao.addStudent(s2);
        dao.updateStudent(new Student(1,"lisi"));
        dao.deleteStudentById(2);*/
    }
}
