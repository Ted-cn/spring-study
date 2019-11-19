package com.cui.factory;

import com.cui.service.impl.AccountService;

public class InstanceFactory {

    public AccountService getAccountService() {
        return new AccountService();
    }
}
