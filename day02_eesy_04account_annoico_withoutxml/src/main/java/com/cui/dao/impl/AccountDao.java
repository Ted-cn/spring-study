package com.cui.dao.impl;


import com.cui.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao implements IAccountDao {

    @Override
    public void save() {
        System.out.println("账户已经保存了");
    }
}
