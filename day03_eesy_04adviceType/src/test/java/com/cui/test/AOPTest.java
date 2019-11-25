package com.cui.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cui.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AOPTest {

    @Autowired
    @Qualifier("accountService")
    private IAccountService accountService;

    @Test
    public void name() {
        accountService.saveAccount();
        accountService.updateAccount(1);
        accountService.deleteAccount();
    }
}
