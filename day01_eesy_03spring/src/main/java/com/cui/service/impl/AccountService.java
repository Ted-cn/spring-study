package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.dao.impl.AccountDao;
import com.cui.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountService implements IAccountService {

    private IAccountDao accountDao = new AccountDao();

    public void save() {
        accountDao.save();
    }
}
