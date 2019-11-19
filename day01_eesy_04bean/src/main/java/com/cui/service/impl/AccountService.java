package com.cui.service.impl;

import com.cui.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountService implements IAccountService {

    public AccountService() {
        System.out.println("对象创建了");
    }

    public void save() {
        System.out.println("save方法执行了");
    }

    public void init() {

    }
}
