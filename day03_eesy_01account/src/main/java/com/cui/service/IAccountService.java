package com.cui.service;

import com.cui.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface IAccountService {

    List<Account> findAllAccount();
    Account findAccoutById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);

    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
