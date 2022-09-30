package com.briup.service;

/**
 *   要求所有的方法提供执行的日志记录功能。
 * 1.目标类
 *  当系统运行时，希望service层对象实现调用逻辑功能
 * 2.目标对象
 *   new UserService();
 * 3.目标对象作用： 实现业务功能
 *   service.addUser();
 * 4.需要提供增强的功能(方法)，创建一个代理类
 *
 * @Author lining
 * @Date 2022/9/30
 */
public class UserService implements IUserService{
    public void addUser(){
        System.out.println("添加学生信息");
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void findAllUser() {

    }
}
