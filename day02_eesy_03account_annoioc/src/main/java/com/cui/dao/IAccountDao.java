package com.cui.dao;

import com.cui.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    List<Account> findAllAccount();
    Account findAccoutById(Integer id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);

}
