package com.briup.dao;

import com.briup.bean.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 持久层代码：访问数据库实现管理Bean学生信息操作
 * @Author lining
 * @Date 2022/10/6
 */
@Repository
@Data//set注入
public class StudentDao {//ioc容器管理
    @Autowired //<properties ... ref="jt">
    private JdbcTemplate jdbcTemplate;//成员变量，每个方法都可以使用该对象进行操作

    //查询
    public int findStudentCount(){
        String sql = "select count(*) from t_student";
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        return count;
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
        String sql = "select id,name from t_student";
        //java8:
        List<Student> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            //中有20个属性值需要设置
            int id = rs.getInt("id");
            String name = rs.getString("name");
            //student.setXXX  20个方法
            // id salary  (100,"jack",100)
            //new Student(a,b,c,d,e,f,.......)  一个方法

            //使用建造者模式实现创建一个Student对象
            Student student = Student.builder().id(id)
                                                .name(name)
                    //      salary(1000).age(20).XXXX().XXX().XXX()
                                                .build();
            return student;
        });
        return list;
    }
    public void addStudent(Student s){
        String sql = "insert into t_student values(?,?)";
        Object[] args = {s.getId(),s.getName()};
        jdbcTemplate.update(sql, args);
    }
    public void updateStudent(Student s){
        String sql = "update t_student set name = ? where id = ?";
        Object[] args = {s.getName(),s.getId()};
        jdbcTemplate.update(sql,args);
    }
    public void deleteStudentById(int id){
        String sql = "delete from t_student where id = ?";
        jdbcTemplate.update(sql,id);
        //update方法实现执行create语句
    }
    //query   queryForObject update
    //e_detail_X  1-31


}
