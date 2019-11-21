package com.cui.ui;

import com.cui.dao.IAccountDao;
import com.cui.dao.impl.AccountDao;
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
     * 获取spring的IOC核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类：
     *     1. ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径。
     *     2. FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）。
     *     3. AnnotationConfigApplicationContext：用于读取注解创建容器。
     *
     * 核心容器的两个接口引发出的问题：
     *     ApplicationContext：单例对象适用
     *         创建核心容器时，创建对象采取的策略是立即加载的方式。也就是说，只要一读取完配置文件，马上就创建配置文件中配置的对象。
     *     BeanFactory：多例对象适用
     *         它在创建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才能真正地创建对象。
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


        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        IAccountService accountService1 = beanFactory.getBean("accountService", AccountService.class);

        //XmlBeanFactory beanFactory = new ClassPathXmlApplicationContext();
    }
}
