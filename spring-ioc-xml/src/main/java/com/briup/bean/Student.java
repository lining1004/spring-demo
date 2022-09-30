package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 使用Lombok插件实现生成样本化代码。
 * @Author lining
 * @Date 2022/9/29
 */
@NoArgsConstructor  //生成无参构造器
//@AllArgsConstructor  //生成全参构造器
@Data //lombok注解 自动生成代码
public class Student {
    private int id;
    private String name;
    private Date dob;//=new Date();
    private int age;
    /*public Student() {
        System.out.println("调用student构造器，创建对象");
    }

    */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, Date dob, int age) {
        System.out.println("调用全参构造器");
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
    }

    public void init(){
        System.out.println("创建Student对象后调用方法，初始化操作");
    }
    public void destory(){
        System.out.println("Student对象销毁前，调用销毁方法");
    }

    /*public void setId(int id) {
        System.out.println("调用setId");
        this.id = id;
    }
    public void setAge(int age){
        System.out.println("调用setAge");
    }
    public void setName(String name) {
        System.out.println("调用setName");
        this.name = name;
    }
    //构造器 无参 全参

    // get  set

    // toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/
}
