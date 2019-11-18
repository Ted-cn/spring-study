package com.cui.ui;

import com.cui.dao.IAccountDao;
import com.cui.dao.impl.AccountDao;
import com.cui.service.IAccountService;
import com.cui.service.impl.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类：
     *     1. ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径。
     *     2. FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）。
     *     3. AnnotationConfigApplicationContext：用于读取注解创建容器。
     */
    public static void main(String[] args) {
        //IAccountService accountService = new AccountService();
        // 1. 获取核心窗口对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取bean对象
        IAccountService accountService = ac.getBean("accountService", AccountService.class);
        IAccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);

        accountService = ac.getBean("accountService", AccountService.class);
        System.out.println(accountService);

    }
}
