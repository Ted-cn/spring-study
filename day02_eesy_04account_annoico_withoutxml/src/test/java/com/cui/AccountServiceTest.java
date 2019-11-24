package com.cui;

import com.cui.config.SpringConfiguration;
import com.cui.domain.Account;
import com.cui.service.IAccountService;
import com.cui.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Spring整合JUnit的配置：
 * 1. 导入Spring整合JUnit的jar（坐标）
 * 2. 使用JUnit提供的一个注解把原有的main方法替换成Spring提供的@Runwith
 *     @RunWith(SpringJUnit4ClassRunner.class)
 * 3. 指定xml文件或注解类的位置
 *     @ContextConfiguration(classes = SpringConfiguration.class)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

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
