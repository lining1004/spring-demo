package com.briup.dao;

import com.briup.bean.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author lining
 * @Date 2022/10/7
 * 需要的依赖：需要什么类型对象可以操作数据库的对象
 * connection sqlSession 映射器  ...
 */
@Data
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student selectStudentById(int id){
        return null;
    }


    public void deleteStudentById(int id){
        String sql = "delete from t_student where id = ?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
}
