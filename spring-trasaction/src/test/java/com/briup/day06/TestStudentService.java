package com.briup.day06;

import com.briup.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟web层调用service层
 * @Author lining
 * @Date 2022/10/7
 */
public class TestStudentService {
    @Test
    public void web(){
        ApplicationContext container = new ClassPathXmlApplicationContext("tx.xml");
        IStudentService service = container.getBean(IStudentService.class);
        service.deleteStudent(2);

        //service.deleteStudents(1,2,3);
        //观察当异常发生时，数据库数据变化。是否可以实现事务的原子性 不可以。
        /*
            通过spring-tx框架提供的事务管理代码实现当异常发生时，可以实现事务回滚。
            当实现事务管理操作后：
            service方法中执行的dao层sql语句：同一个事务中。
            同时执行成功。同时执行失败（没有发生改变）

         */


    }


}
