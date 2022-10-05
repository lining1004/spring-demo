package com.briup.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当方法执行前需要权限验证时，使用注解定义在方法上
 *
 */
@Target(ElementType.METHOD) //只用在方法上
@Retention(RetentionPolicy.RUNTIME) //resouce class
public @interface Role {

}
