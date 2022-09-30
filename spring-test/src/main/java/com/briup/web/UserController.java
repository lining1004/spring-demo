package com.briup.web;

import com.briup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@Controller
public class UserController {
    @Autowired //属性注入。不需要和构造set方法器
    private UserService service;//从ioc容器中获取该对象


    public void findUserById(int id){
        System.out.println("web...find");
        //空指针异常
        service.findUserById(id);
    }
}
