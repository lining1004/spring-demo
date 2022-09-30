package com.briup.service;

/**
 * 代理类：
 * 作用：增强目标类中方法的功能：日志记录功能 权限判断
 * @Author lining
 * @Date 2022/9/30
 */
public class UserServiceProxy implements IUserService{
    private IUserService target;

    public UserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void addUser() {
        //1.日志记录
        System.out.println("开始执行添加方法");
        //2.权限判断
        String role = "admin";
        if(role.equals("admin")){//有权限添加
            //目标对象调用添加方法
            target.addUser();
        }
        System.out.println("执行添加结束");
    }

    @Override
    public void updateUser() {
       //sout
       target.updateUser();
       //sout
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void findAllUser() {

    }
    //添加用户信息

}
