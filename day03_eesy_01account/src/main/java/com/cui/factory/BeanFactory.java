package com.cui.factory;

import com.cui.domain.Account;
import com.cui.service.IAccountService;
import com.cui.service.impl.AccountServiceImpl;
import com.cui.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.txManager = transactionManager;
    }

    public IAccountService getAccountService() {
        IAccountService proxyAccountService = (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            // 1. 开启事务
                            txManager.beginTransaction();
                            // 2. 执行操作
                            Object rtObj = method.invoke(accountService, args);
                            // 3. 提交事务
                            txManager.commit();
                            // 4. 返回结果
                            return rtObj;
                        } catch (Exception e) {
                            // 5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 6. 释放连接
                            txManager.release();
                        }
                    }
                });
        return proxyAccountService;
    }

}
