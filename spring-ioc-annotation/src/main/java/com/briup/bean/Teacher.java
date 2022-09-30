package com.briup.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Data
@Component("t")
public class Teacher {
    @Value("202201")
    private int id;
    @Value("tom")
    private String name;
    /*
    * @Autowired : 表示自动装配属性对应的bean对象  自动注入bean对象
    *  1.使用该注解，需要在ioc容器提供一个Course类型对应的bean对象，
    * 如果没有，运行错误。 解决方案：
    * required = false 当ioc容器中没有该类型对象，不会提示找不到对象错误
    * 2.自动装配基于ByTpype类型查找ioc容器bean对象。
    *   当ioc容器中有多个相同类型的对象时，自动注入提示多个bean对象错误信息。
    *   在多个相同类型的bean时，指定bean对象名称可以确定唯一一个bean
    *   解决方案：@Qualifier("c")
     * */
    //@Autowired(required = false)//required = false ioc容器的注入的对象可以为null，
    @Autowired(required = true) //required = true 默认必须提供一个bean对象注入
    @Qualifier("c")  //表示注入指定名称的对象
    private Course course;//引入类型变量
    /*
      基于bean对象的名称获取,当有多个teacher对象基于ByName方式获取

     */
    @Resource(name = "p3") //默认需要在ioc容器中提供一个Person对象
    private Person person;
    @Resource //基于bean对象的名称获取值。默认名称就是属性名
    private Person p3;

    @PostConstruct //调用初始化方法 init-method
    public void init(){
        System.out.println("init...");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }
}
