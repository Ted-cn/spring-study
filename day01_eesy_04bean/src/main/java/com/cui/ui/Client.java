package com.cui.ui;

import com.cui.service.IAccountService;
import com.cui.service.impl.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取核心窗口对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取bean对象
        IAccountService accountService = ac.getBean("accountService", AccountService.class);
        System.out.println(accountService);
    }
}
