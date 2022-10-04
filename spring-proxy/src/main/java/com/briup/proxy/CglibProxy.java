package com.briup.proxy;

import com.briup.service.StudentService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 通过cglib动态代理实现对业务方法updateStudent()
 * 添加日志记录功能（增强功能）
 * 目的：创建代理类 代理方法 日志+更新
 * 通过创建目标类的子类对象 实现代理对象
 * @Author lining
 * @Date 2022/10/4
 */
public class CglibProxy {
    public static void main(String[] args) {
        //1.创建一个增强器对象
        Enhancer enhancer = new Enhancer();
        //2.指定代理对象的父类型(目标对象的类型 目标类)
        enhancer.setSuperclass(StudentService.class);
        //3.编写代理对象的日志功能代码
        enhancer.setCallback(new MethodInterceptor() {

            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                //代理增强功能：日志功能
                System.out.println(new Date()+" 开始执行方法");//代理功能
                Object result = proxy.invokeSuper(obj, args);//调用目标对象的方法（被代理的方法）
                //ctrl+shif+方向键 移动行代码
                System.out.println(new Date()+" 结束执行方法");//代理功能
                return result;
            }
        });//MethodInterceptor接口的匿名对象作为参数
        //4.通过增强器实现获取代理对象 
        StudentService proxy = (StudentService) enhancer.create();
        System.out.println("代理对象："+proxy.getClass());
        //5.通过代理调用方法实现业务功能：更新学生信息
        proxy.updateStudent();
        //class com.briup.service.StudentService
        //class com.briup.service.StudentService$$EnhancerByCGLIB$$229ff3e2
        //代理类和 目标类之间关系： 代理类是目标类的子类

    }
}
