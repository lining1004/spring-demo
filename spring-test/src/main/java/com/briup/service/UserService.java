package com.briup.service;

import com.briup.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public void findUserById(int id) {
        System.out.println("service...");
        dao.findUserById(id);
    }
}
