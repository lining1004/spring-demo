package com.briup.day03;

import com.briup.service.IStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lining
 * @Date 2022/10/4
 */
public class TestAOP {
    @Test
    public void getBean(){
        //1.获取容器对象(map集合)
        ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        //2.获取业务service对象
        IStudentService service = container.getBean(IStudentService.class);
        service.findStudentById(1);

        service.addStudent();


    }
}
