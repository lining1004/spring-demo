package com.briup.day01;

import com.briup.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Map;

/**
 * 获取ioc容器中bean对象
 * @Author lining
 * @Date 2022/9/29
 */
public class TestStudent {
    @Test
    public void getBean(){
        /*
            1.读取在类路径下的xml配置文件信息，获取到ioc容器对象

            相对路径  类路径 classes
            绝对路径
         */
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext
                        ("application.xml");
        //2.通过ioc容器(Map集合存储信息)对象获取指定的bean对象
        Object obj = container.getBean("s");
        if(obj instanceof Student){
            Student s = (Student) obj;
        }
        System.out.println(obj);
        Object s2 = container.getBean("s2");
        System.out.println(s2);
        //是不是同一个对象
        System.out.println(obj == s2);
        Object s3 = container.getBean("s3");
        System.out.println("s3:"+s3);
        Object s5 = container.getBean("s5");
        System.out.println("s5:"+s5);
       // Object stu = container.getBean("stu"); 运行异常：没有该对象
       // System.out.println(stu);
        Map<String, Student> map = container.getBeansOfType(Student.class);
        System.out.println(map);
    }
    @Test
    public void getBean2(){
        //1.读取非类路径下的xml配置文件，获取ioc容器
        String abspath = "D:\\workspace\\spring-demo\\spring-ioc\\src\\main\\resources\\application.xml";
        String path = "src/main/resources/application.xml";//相对路径 项目 java.io
        FileSystemXmlApplicationContext container = new FileSystemXmlApplicationContext(path);
        //2.获取指定名称的bean对象
        Student stu = (Student) container.getBean("s");
        System.out.println(stu);
        //都有相同的父类 接口 定义方法
        //ApplicationContext 接口 是ioc容器的类型 shift+shift
        //ctrl+h  查看类的继承关系
    }
    @Test
    public void getBean3(){
        //1.读取配置文件创建ApplicationContext接口对象
        ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("-------");
        Object s6 = container.getBean("s6");
        System.out.println(s6);
    }
    @Test
    public void getBeanByfactory(){
        //将工厂类生成对象存放ioc容器中进行管理
        ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        Object s7 = container.getBean("s7");
        System.out.println(s7);//id=1 name=jack
        Object s8 = container.getBean("s8");
        System.out.println(s8);// id=2
    }
    @Test
    public void getBean4(){
        //1.创建容器
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application2.xml");
        //单例：UserService对象  调用方法
        //多例： 每次获取对象进行修改对象的属性值
        Object s2 = container.getBean("s");
        Object s3 = container.getBean("s");
        System.out.println(s2 == s3);
        //3.程序自动停止：内存信息回收jv
        Student s4 = container.getBean(Student.class);
        System.out.println("s4:"+s4);
        /*
            手动销毁容器对象,调用每个bean对象的销毁方法
            如果bean对象时单例模式的话：容器的销毁自动调用对象的销毁方法，对象销毁
            如果是多例模式。容器销毁的时，不会调用
         */
        container.close();


    }
    @Test
    public void getBean5(){
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("set.xml");
        Object s = container.getBean("s");
        System.out.println("s:"+s);
        Object t = container.getBean("t");
        System.out.println("teacher: "+t);
    }
    @Test
    public void getBean6(){
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("set.xml");
        Object t2 = container.getBean("t2");
        System.out.println(t2);
        Object p = container.getBean("p");
        System.out.println(p);
        Object s4 = container.getBean("s4");
        System.out.println(s4);
    }

}