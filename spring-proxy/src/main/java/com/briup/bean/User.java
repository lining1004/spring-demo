package com.briup.bean;

import com.briup.service.UserService;
import com.briup.service.UserServiceProxy;

/**
 * 表示测试类:测试静态代理 类比邀请歌手的用户
 * @Author lining
 * @Date 2022/9/30
 */
public class User {

    public void method(Singer singer){
        singer.sing("abc");
    }

    public static void main(String[] args) {
        //1.测试代码
        User user = new User();
        //2.创建目标对象
        Target target = new Target("tom");//具体的tom歌手
        //3.创建代理对象，并提供具体的目标对象（执行核心代码的对象）
        Proxy proxy = new Proxy(target);//经纪人对象
        //4.客户通过代理人实现唱歌的活动
        user.method(proxy);


        //1.创建目标对象 代理对象
        UserServiceProxy proxy2 = new UserServiceProxy(new UserService());
        proxy2.addUser();
    }
}
