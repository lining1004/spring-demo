package com.briup.proxy;

import com.briup.bean.Singer;
import com.briup.bean.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理：java中反射包中提供类和方法，不需要引用新的jar
 *
 * @Author lining
 * @Date 2022/9/30
 */
public class JDKProxy {
    public static void main(String[] args) throws Exception{
        //1.通过JDK动态代理生成代理对象

        //1.类加载器对象
        Class<?> target = Class.forName("com.briup.bean.Target");
        ClassLoader classLoader = target.getClassLoader();
        //ClassLoader classLoader1 = Target.class.getClassLoader();
        //2.目标类的接口字节码信息
        Class<?>[] interfaces = target.getInterfaces();
        //3.内部类对象创建InvocationHandler
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理类信息："+proxy.getClass());
                System.out.println("被代理的方法："+method.getName());
                System.out.println("被代理方法的参数值："+ Arrays.toString(args));
                System.out.println("签合同");
                //调用目标方法进行执行
                Target target = new Target();
                Object result = method.invoke(target, args);
                System.out.println("收钱");
                return result;//目标方法的返回值
            }
        };
        //返回一个代理对象
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o instanceof Singer);

        Singer proxy = (Singer) o;

        //通过代理对象调用接口中sing方法
        String msg
                = proxy.sing("abc");//目标方法逻辑+代理方法逻辑
        System.out.println("接收返回值："+msg);
        System.out.println("代理对象的类型："+o.getClass());


        System.out.println("---------------");
        //调用歌手的run方法
        proxy.run();


    }
}