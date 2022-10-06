package com.briup.day05;

import com.briup.bean.Student;
import com.briup.config.AppConfig;
import com.briup.dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @Author lining
 * @Date 2022/10/6
 */
@SpringJUnitConfig(classes = AppConfig.class)
public class TestSudentDaoAnno {
    @Autowired
    private StudentDao dao;
    @Test
    public void service(){
        List<Student> list =
                dao.findAllStudent();
        //遍历list
        list.forEach(s -> System.out.println(s));
    }
}
