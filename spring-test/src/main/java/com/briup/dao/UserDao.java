package com.briup.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Repository
public class UserDao {

    public void findUserById(int id) {
        System.out.println("连接数据库，进行查询");
    }
}
