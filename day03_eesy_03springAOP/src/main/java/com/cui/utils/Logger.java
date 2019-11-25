package com.cui.utils;

/**
 * 日志工具类
 */
public class Logger {
    /**
     * 打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog() {
        System.out.println("Logger类中的printLog方法开始记录日志了");
    }
}
