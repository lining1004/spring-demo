package com.briup.proxy;

import com.briup.service.IUserService;
import com.briup.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @Author lining
 * @Date 2022/9/30
 */
public class UserServiceJDKProxy {
    public static void main(String[] args) {
        //1.通过反射包创建出代理对象
        Class c = UserService.class;
        //目标对象
        UserService target = new UserService();
        //2.代理对象
        IUserService proxy = (IUserService) Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(new Date() + " 开始执行");
                //调用目标对象的方法
                Object result = method.invoke(target, args);

                System.out.println(new Date() + " 结束执行");
                return result;
            }
        });
        proxy.addUser();
        proxy.updateUser();
        proxy.deleteUser();
        proxy.findAllUser();
    }
}
