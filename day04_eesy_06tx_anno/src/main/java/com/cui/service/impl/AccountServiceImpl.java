package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import com.cui.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
@Async
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer id) throws Exception {
        return accountDao.findAccountById(id);
    }

    @Override
    public void tranfer(String sourceName, String targetName, Float money) throws Exception {
        accountDao.tranfer(sourceName, targetName, money);
    }
}
