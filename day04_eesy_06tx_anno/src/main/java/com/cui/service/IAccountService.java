package com.cui.service;

import com.cui.domain.Account;

public interface IAccountService {

    Account findAccountById(Integer id) throws Exception;

    void tranfer(String sourceName, String targetName, Float money) throws Exception;
}
