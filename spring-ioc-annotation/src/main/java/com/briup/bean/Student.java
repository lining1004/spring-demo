package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Component("s2")//<bean></bean>表示创建该类的对象，存放在springioc容器中，
//@Controller("s2") //web层创建bean对象
//@Service("s2")  //service层创建bean对象
@Repository("s2") // dao层创建bean对象 4个组件相关注解 作用一样 区别 在使用三层不同，
public class Student {
    @Value("1") //属性赋值 依赖注入 <property> 标签
    private int id;
    @Value("jack")
    private String name;
    @Value("#{t}") //获取ioc容器的teacher对象  对象的名称
    private Teacher teacher;//引入类型变量 =new Teacher();
}
