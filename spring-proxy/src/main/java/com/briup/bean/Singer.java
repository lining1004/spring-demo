package com.briup.bean;

/**
 *主题类角色 表示代理类和目标类共同拥有的身份
 * @Author lining
 * @Date 2022/9/30
 */
public interface Singer {
    //唱歌
    String sing(String name);

    //其他方法
    void run();//被代理
}
