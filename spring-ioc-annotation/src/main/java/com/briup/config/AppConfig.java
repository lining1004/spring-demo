package com.briup.config;

import com.briup.bean.Student;
import com.briup.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 应用程序配置类 = xml配置文件
 * 1.使用bean标签创建bean对象
 *  ---@组件注解 实现 定义每个业务类的上面
 *  ---工厂类创建对象 通过调用方法将返回对象放在ioc容器
 * 2.配置注解扫描包的位置  <context:....></context:....>
 *
 * @Author lining
 * @Date 2022/9/30
 */
@Configuration//配置类
//@ComponentScan("com.briup.bean")
@ComponentScan(basePackages = "com.briup.bean")
@PropertySource("userInfo.properties") //读取配置文件的内容
@Import(GroupConfig.class) //导入其他类作为配置类,可以省略Configuration注解
public class AppConfig {
    @Value("${user.id}") //获取配置文件对应的value值
    private int userId;
    @Value("${user.username}")
    private String username;

    /**
     * 将方法的返回值对象存在ioc容器中  对象名称默认是方法的名称getUser
     *  User#0
     *  name = "u"  value="u" 表示对象的名称
     *
     * @return
     */
    @Bean(name = "u") //
    public User getUser(){
        System.out.println("bean....");
        return new User(1,"tom");
    }
    @Bean//当前创建的对象名称为方法名 u2
    public User u2(){
        return new User(userId,username);
    }

}
