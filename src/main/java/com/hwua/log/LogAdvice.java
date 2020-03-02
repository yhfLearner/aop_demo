package com.hwua.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
/* 用注解配置AOP时，推荐使用环绕通知 */
public class LogAdvice {
    //配置全局切入点
    @Pointcut("execution(* com.hwua.service..StudentServiceImpl.*(..))")
    public void p1() {
    }

    //JoinPoint joinPoint用来接收切入点
    @Before("p1()")
    //局部切入点
    //@Before("execution(* com.hwua.service..StudentServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        /*Object[] args = joinPoint.getArgs();
        System.out.println("切入点方法的参数值:"+ Arrays.toString(args));
        Signature signature = joinPoint.getSignature();
        System.out.println("切入点的方法名(被增强的方法名):"+signature.getName());*/
        System.out.println("日志记录开始");

    }

    @AfterReturning("p1()")
    public void logAfterReturning() {
        System.out.println("日志记录完毕");
    }

    @AfterThrowing("p1()")
    public void logAfterThrowing() {
        System.out.println("日志记录错误信息");
    }

    @After("p1()")
    public void logAfter() {
        System.out.println("日志关闭");
    }

    /**
     * 环绕通知目标方法都要自己去调用
     * ProceedingJoinPoint pjp 切入点
     *
     * @return
     */
    /*@Around("p1()")*/
    public Object around(ProceedingJoinPoint pjp) {
        Object obj = null;
        Object[] args = pjp.getArgs();//获取切入点所有的方法参数
        try {
            //前置通知
            logBefore(pjp);
            obj = pjp.proceed(args);//调用切入点的方法(目标方法)
            logAfterReturning();//后置通知
        } catch (Throwable throwable) {
            logAfterThrowing();//异常通知
            throwable.printStackTrace();
        } finally {
            logAfter();//最终通知
        }
        //System.out.println("环绕通知");
        return 1;
    }
}
