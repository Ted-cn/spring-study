package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import com.cui.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return null;
    }

    @Override
    public void tranfer(String sourceName, String targetName, Float money) {

    }
}
