package com.cui.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志工具类
 */
@Component("logger")
// 表示当前是一个切面类
@Aspect
public class Logger {
    @Pointcut("execution(* com.cui.service.impl.*.*(..))")
    private void pt(){}
    /**
     * 前置通知
     */
    @Before("pt()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的printLog方法开始记录日志了");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的printLog方法开始记录日志了");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的printLog方法开始记录日志了");
    }

    /**
     * 最终通知
     */
    @After("pt()")
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的printLog方法开始记录日志了");
    }

    /**
     * 环绕通知
     * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个proceed()方法，此方法就相当于明确调用切入点方法。
     * 该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该接口的实现类供我们使用。
     *
     * Spring中的环绕通知：
     *     它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue;
        try {
            // 得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的printLog方法开始记录日志了。。。前置");
            // 明确调用业务层方法（切入点方法）
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中的printLog方法开始记录日志了。。。后置");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("Logger类中的printLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("Logger类中的printLog方法开始记录日志了。。。最终");
        }
    }
}
