package com.briup.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 权限切面类：保存重复的代码
 * @Author lining
 * @Date 2022/10/5
 */
@Component //表示一个切面对象，用来调用方法 <bean>
@Aspect//表示当前类是一个切面类 <aop:aspect>
public class RoleAspect {
    //aop:config :定义在这个类中

    //切入点配置 <aop:pointCut>
    @Pointcut("execution(* com.briup.service..*.*(..))")
    public void myPointCut(){
        //定义切入点：配置方法的规则
    }
    //当方法使用了Logging注解后，被切面类织入通知
    @Pointcut("@annotation(Role)")
    public void myPointCut2(){
        //切入点的名称就是方法的名称
        //注解：表示切入点的规则： 表达式
    }
    //切入点规则： 且关系 通知满足2个表达式规则
    @Pointcut("execution(* com.briup.service..*.*(..)) && @annotation(Role)")
    public void myPointCut3(){
        //切入点的名称就是方法的名称
        //注解：表示切入点的规则： 表达式
    }


    @Before("myPointCut3()")
    public void roleAdvice(){
        System.out.println("进行用户身份验证");
    }



    //通知配置  <aop:before pointCut-ref>
    @Before("myPointCut()")
    public void beforeAdvice(){
        System.out.println("判断用户是否有权限执行该方法...前置通知");
    }
    @After("myPointCut()")
    public void afterAdvice(){
        System.out.println("后置通知");
    }
    @AfterReturning("myPointCut()")
    public void afterRetrun(){
        System.out.println("后置返回通知");
    }
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void throwAdvice(Exception e){
        //可以获取到异常信息对象，进行异常处理
        System.out.println("异常通知:"+e.getMessage());
    }
    //环绕通知：前置+返回后置
    @Around("myPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        System.out.println("开始环绕通知...");
        //调用目标对象中的方法,获取返回值
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            //e.printStackTrace();
        }
        System.out.println("结束环绕通知...");
        return  result;
    }
}
