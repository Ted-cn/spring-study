package com.cui.test;


import com.cui.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest2 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
        accountService.deleteAccount();
        accountService.updateAccount(1);
    }
}
