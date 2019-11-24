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

    /**
     * 根据名称查询账户
     * @param name
     * @return 1. 查询结果只有一个账户，正常返回
     *         2. 查询结果为空，返回null
     *         3. 查询结果有多个，抛出异常
     */
    Account findAccoutByName(String name);
}
