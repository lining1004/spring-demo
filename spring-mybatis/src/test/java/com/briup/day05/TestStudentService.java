package com.briup.day05;

import com.briup.bean.Student;
import com.briup.config.AppConfig;
import com.briup.dao.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 测试使用注解方法获取映射器对象
 * @Author lining
 * @Date 2022/10/6
 */
@SpringJUnitConfig(classes = AppConfig.class)
public class TestStudentService {
    @Autowired
    private StudentMapper mapper;
    @Test
    public void findStudentById(){
        Student s = mapper.findStudentById(1);
        System.out.println("查询结果："+s);
        //update insert delete 省略
        //1：1   1：N   省略
        // 动态sql   省略
        // mybatis: 日志功能 log4j

    }

}
