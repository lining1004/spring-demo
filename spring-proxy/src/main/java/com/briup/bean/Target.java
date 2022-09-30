package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目标类：（核心）提供的功能的类 （类比歌手）
 * 特点： 只实现核心功能。增强代码不会添加到目标类
 * @Author lining
 * @Date 2022/9/30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Target implements Singer{
    private String name;
    @Override
    public String sing(String name) {
        System.out.println("唱歌....");
        return "target";
    }

    @Override
    public void run() {
        System.out.println("运动....");
    }
}
