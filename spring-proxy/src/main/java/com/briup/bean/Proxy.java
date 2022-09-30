package com.briup.bean;

/**
 * 静态代理：
 * 1.代理类是用户手动创建，执行代理方法前创建出来。
 * 表示代理类 类比经纪人
 * @Author lining
 * @Date 2022/9/30
 */
public class Proxy implements Singer{
    private Singer singer;//真实的目标对象的引用

    public Proxy(Singer singer) {
        this.singer = singer;//目标对象的赋值
    }

    @Override
    public String sing(String name) {//唱歌的活动
        System.out.println("签合同");//增强的操作
        //歌手唱歌
        singer.sing(name);
        System.out.println("收钱");//增强的操作
        return "proxy";
    }

    @Override
    public void run() {

    }
}
