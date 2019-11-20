package com.cui.dao.impl;


import com.cui.dao.IAccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AccountDao1 implements IAccountDao {

    @Override
    public void save() {
        System.out.println("账户已经保存了");
    }
}
