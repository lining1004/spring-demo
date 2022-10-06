package com.briup.day05;

import com.briup.bean.Student;
import com.briup.dao.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author lining
 * @Date 2022/10/6
 */
public class TestMybatis {
    @Test
    public void service(){
        //1.读取配置文件
       ApplicationContext container = new ClassPathXmlApplicationContext("mybatis-spring.xml");
        //2.获取映射器对象
        String[] names = container.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
        StudentMapper mapper = container.getBean(StudentMapper.class);
        Student s = mapper.findStudentById(1);
        System.out.println(s);
    }
}
