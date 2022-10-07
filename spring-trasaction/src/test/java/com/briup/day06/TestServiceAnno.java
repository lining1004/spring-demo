package com.briup.day06;

import com.briup.config.AppConfig;
import com.briup.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author lining
 * @Date 2022/10/7
 */
@SpringJUnitConfig(classes = AppConfig.class)
public class TestServiceAnno {
    @Autowired
    private IStudentService service;

    @Test
    public void web(){
        service.deleteStudent(2);
        //实现效果：异常发生，数据回滚
    }
}
