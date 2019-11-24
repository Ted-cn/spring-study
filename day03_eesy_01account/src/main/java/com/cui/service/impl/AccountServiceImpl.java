package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import com.cui.service.IAccountService;
import com.cui.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccoutById(Integer id) {
        return accountDao.findAccoutById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccoutByName(sourceName);
        Account target = accountDao.findAccoutByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
