package com.cui.service;

import com.cui.domain.Account;

public interface IAccountService {

    Account findAccountById(Integer id);

    void tranfer(String sourceName, String targetName, Float money);
}
