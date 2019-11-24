package com.cui;

import com.cui.domain.Account;
import com.cui.service.IAccountService;
import com.cui.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    private ApplicationContext ac;
    private IAccountService accountService;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("beans.xml");
        accountService = ac.getBean("accountService", AccountServiceImpl.class);
    }

    @Test
    public void testFindAll() {
        List<Account> list = accountService.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findAccoutById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("dddd");
        account.setMoney(2000.0f);
        accountService.saveAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
}

    @Test
    public void testUpdate() {
        Account account = accountService.findAccoutById(4);
        account.setName("ddd");
        accountService.updateAccount(account);
    }
}
