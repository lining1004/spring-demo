package com.briup.day02;

import com.briup.bean.Person;
import com.briup.bean.Student;
import com.briup.bean.Teacher;
import com.briup.bean.User;
import com.briup.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 测试springioc相关注解：
 *   简化xml文件的配置
 * @Author lining
 * @Date 2022/9/30
 */
public class TestAnnotation {
    @Test //父项目获得junit框架依赖信息
    public void getBean(){
        //1.读取xml配置文件，获取ioc容器对象
        ApplicationContext container = new ClassPathXmlApplicationContext("annotation.xml");
        //2.获取使用注解的Student类的对象
        Student s = container.getBean(Student.class);
        System.out.println(s);
        //s对象在ioc容器中的名称是什么？ 默认名字 student 类名首字母小写
        Map<String, Student> map = container.getBeansOfType(Student.class);
        System.out.println(map);
       // Object s2 = container.getBean("student");
        Object s2 = container.getBean("s2");
        System.out.println(s2 == s);


        System.out.println("test");
    }
    @Test
    public void getBean2(){
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("annotation.xml");
        Teacher teacher = container.getBean(Teacher.class);
        System.out.println(teacher);
        container.close();//注意对象是单例模式，才会调用销毁方法
        //Object p = container.getBean("p");
    }
    @Test //不使用xml配置文件的获取bean对象
    public void getBeanByAnnotation(){
        //1.创建ioc容器对象。查找注解路径：当前包及其子包
        ApplicationContext container = new AnnotationConfigApplicationContext("com.briup");
        Person p = container.getBean(Person.class);
        System.out.println(p);
    }
    @Test
    public void getBeanByConfig(){
        //1.读取配置类，获取ioc容器
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<String, User> map = container.getBeansOfType(User.class);

        System.out.println(map);
        Person p = container.getBean(Person.class);
        System.out.println(p);
        Object u2 = container.getBean("u2");
        System.out.println("u2: "+u2);
        String username = System.getProperty("user.name");
        System.out.println("系统名称："+username);
    }
    @Test
    public void getBeanByMoreConfig(){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Object group = container.getBean("group");
        System.out.println(group);
    }
}
