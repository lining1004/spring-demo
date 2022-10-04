package com.briup.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * 切面类 ：项目中重复代码（每个模块多次重复使用代码）
 * @Author lining
 * @Date 2022/10/4
 */
public class LogAspect {
    //指定该方法在切入点的什么位置执行
    public void beforeAdvice(){
        //希望该方法在切入点执行前被代理对象调用执行
        System.out.println("前置通知...");
    }
    /*
      当切入点方法执行结束后，执行后置通知的代码
      配置 findStudentById 与 afterAdvice 关系
     */
    public void afterAdvice(){
        //无论切入点是否发生异常，都会执行后置通知。finally{....}
        System.out.println("后置通知....");
    }

    public void afterReturn(){
        /*
            当切入点发生异常，该后置通知不执行。

            try{
                前置通知
                目标方法执行
                后置返回通知
            }catch(Exception e){
                处理e对象
                异常通知
            }finally{
                后置通知
            }
         */
        System.out.println("后置返回通知....");
    }
    //异常通知： 当切入点发生异常发生时，调用该方法
    public void throwAdvice(Exception e){
        //可以在异常通知中获取异常对象信息
        System.out.println("异常通知..."+e.getMessage());
    }
    /*
        环绕通知：在方法前和方法后执行
        在方法内部进行切入点方法的调用
     */
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("开始环绕通知");
        //pjp表示切入点对象（目标对象的方法）
        System.out.println("方法签名："+pjp.getSignature());
        System.out.println("方法参数值："+ Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();//表示调用目标对象的方法
        System.out.println("结束环绕通知");
        return result;
    }

    public void beforeAdvice2(){
        System.out.println("前置通知...使用注解");
    }

}
