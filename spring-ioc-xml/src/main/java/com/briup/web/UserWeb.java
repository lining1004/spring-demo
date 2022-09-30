package com.briup.web;

import com.briup.service.IUserService;
import lombok.Data;

/**
 * @Author lining
 * @Date 2022/9/29
 */
@Data
public class UserWeb {
    //表示web层依赖service层
    private IUserService service;
}
