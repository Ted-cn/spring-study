package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import com.cui.service.IAccountService;
import com.cui.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_old implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.txManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return accounts;
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccoutById(Integer id) {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            Account account = accountDao.findAccoutById(id);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return account;
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.saveAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.updateAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.deleteAccount(id);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 1. 开户事务
            txManager.beginTransaction();
            // 2. 执行操作
            Account source = accountDao.findAccoutByName(sourceName);

            Account target = accountDao.findAccoutByName(targetName);

            source.setMoney(source.getMoney() - money);

            target.setMoney(target.getMoney() + money);

            accountDao.updateAccount(source);
            //int i = 1 / 0;
            accountDao.updateAccount(target);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }
}
