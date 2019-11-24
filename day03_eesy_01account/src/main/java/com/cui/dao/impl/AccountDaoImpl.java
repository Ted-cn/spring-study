package com.cui.dao.impl;

import com.cui.dao.IAccountDao;
import com.cui.domain.Account;
import com.cui.utils.ConnectUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectUtils connectUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectUtils(ConnectUtils connectUtils) {
        this.connectUtils = connectUtils;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectUtils.getThreadConnection(), "select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccoutById(Integer id) {
        try {
            return runner.query(connectUtils.getThreadConnection(), "select * from account where id = ?", new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectUtils.getThreadConnection(), "insert into account(name, money) values (?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectUtils.getThreadConnection(), "update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update(connectUtils.getThreadConnection(), "delete from account where id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccoutByName(String name) {
        try {
            List<Account> accounts = runner.query(connectUtils.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<>(Account.class), name);
            if(accounts == null || accounts.size() == 0) {
                return null;
            }
            if(accounts.size() > 1) {
                throw new RuntimeException("查询结果不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
