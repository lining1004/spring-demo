package com.briup.day04;

import com.briup.bean.Student;
import com.briup.config.AppConfig;
import com.briup.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * junit单元测试：junit4 junit5
 * @Author lining
 * @Date 2022/10/5
 */
@SpringJUnitConfig(classes = AppConfig.class)
public class TestAOP {
    @Autowired //从ioc容器中获取目标对象
    private IStudentService service;
    @Test
    public void doGet(){//模拟web层调用service层代码
        //1.接收参数request
        //2.调用service方法
        Student s = service.findStudentById(1);
        //3.将返回值返回前端：response

    }


}
