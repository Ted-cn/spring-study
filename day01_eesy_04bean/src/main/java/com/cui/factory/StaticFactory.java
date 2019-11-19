package com.cui.factory;

import com.cui.service.impl.AccountService;

public class StaticFactory {

    public static AccountService getAccountService() {
        return new AccountService();
    }
}
