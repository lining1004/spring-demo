package com.briup.dao;

import com.briup.bean.Student;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 持久层代码：访问数据库实现管理Bean学生信息操作
 * @Author lining
 * @Date 2022/10/6
 */
@Data//set注入
public class StudentDao {//ioc容器管理
    private JdbcTemplate jdbcTemplate;//成员变量，每个方法都可以使用该对象进行操作


    //查询
    public int findStudentCount(){
        return 0;
    }
    public Student findStudentById(int id){
        //1.使用jdbcTemplata对象：已经set注入提供：
        String sql = "select id,name from t_student where id = ?";//预编译sql语句
        //创建映射关系对象：解决列名与属性名之间的映射关系
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                //1.通过结果集对象转换为Student对象
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                return stu;
            }
        };
        //sql需要参数:可变参 本质数组
        Object[] args = {1};
        Student s = jdbcTemplate.queryForObject(sql, mapper, args);
        return s;
    }
    public List<Student> findAllStudent(){
        return null;
    }
    public void addStudent(Student s){

    }
    public void updateStudent(Student s){

    }
    public void deleteStudentById(int id){

    }


}
