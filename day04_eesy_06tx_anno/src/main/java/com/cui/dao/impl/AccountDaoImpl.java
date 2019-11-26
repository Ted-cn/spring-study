package com.cui.dao.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        return jdbcTemplate.queryForObject("select * from account where id = ?", Account.class, id);
    }

    @Override
    public Account findAccountByName(String name) throws Exception {
       return jdbcTemplate.queryForObject("select * from account where name = ?", Account.class, name);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void tranfer(String sourceName, String targetName, Float money) throws Exception {
        Account source = this.findAccountByName(sourceName);
        Account target = this.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        this.updateAccount(source);
        this.updateAccount(target);
    }
}
