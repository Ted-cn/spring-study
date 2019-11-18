package com.cui.ui;

import com.cui.factory.BeanFactory;
import com.cui.service.IAccountService;
import com.cui.service.impl.AccountService;

public class Client {

    public static void main(String[] args) {
        //IAccountService accountService = new AccountService();
        IAccountService accountService = (IAccountService)BeanFactory.getBean("accountService");

        accountService.save();
    }
}
