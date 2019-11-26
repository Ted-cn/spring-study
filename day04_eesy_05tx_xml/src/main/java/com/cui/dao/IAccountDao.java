package com.cui.dao;

import com.cui.domain.Account;

public interface IAccountDao {

    Account findAccountById(Integer id) throws Exception;

    Account findAccountByName(String name) throws Exception;

    void updateAccount(Account account);

    void tranfer(String sourceName, String targetName, Float money) throws Exception;
}
