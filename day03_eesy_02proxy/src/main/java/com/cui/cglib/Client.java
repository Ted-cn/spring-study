package com.cui.cglib;

import com.cui.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        Producer producer = new Producer();
        /**
         * 动态代理：
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上，对方法增强
         * 分类：
         *     基于接口的动态代理
         *     基于子类的动态代理
         *
         * 基于子类的动态代理：
         *     涉及的类：Enhancer
         *     提供者：第三方cglib库
         * 如何创建代理对象：
         *     使用Enhancer类中的create()方法
         * 创建代理对象的要求：
         *     被代理类不能是最终类
         * create()方法参数：
         *     Class：用于指定被代理对象的字节码，固定写法。
         *     Callback：用于提供增加的代码，它是让我们写如何代理。
         *         我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，
         *         但不是必须的。此接口的实现类都是谁用谁写。
         */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 提供增强的代码
                Object returnValue = null;
                // 1. 获取方法执行的参数
                Float money = (Float) args[0];
                // 2. 判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(12000f);
    }
}



















