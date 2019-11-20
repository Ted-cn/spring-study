package com.cui.service.impl;

import com.cui.dao.IAccountDao;
import com.cui.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * <bean id="accountService" class="com.cui.service.impl.AccountService"
 * scope="" init-method="" destroy-method="">
 *     <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 注解的分类：
 * 1. 用于创建对象的
 *     他们的作用就是和在XML配置文件中编写一个<bean>标签实现的功能一样
 *     @Component:
 *         作用：用于把当前类对象存入spring容器中
 *         属性：value用于指定bean的id。默认值是首字母小写的当前类名。
 *     @Controller：表现层
 *     @Service：业务层
 *     @Respository：持久层
 *          以上三个注解，他们的作用和属性与Component是一样的，他们是spring框架为我们提供明确的
 *          三层使用的注解，使用我们的三层对象更加清晰。
 * 2. 用于注入数据的
 *     他们的作用就是和在XML配置文件中编写一个<property>标签实现的功能一样
 *     @Autowired:
 *         作用：自动按照类型注入。
 *             当容器中有唯一的一个bean对象类型和要注入的变量类型匹配时，就可以注入成功。
 *             当ioc容器中没有任何bean的类型，和要注入的变量类型匹配时，则报错。
 *             当ioc容器中有多个bean类型匹配时，再匹配bean的名称。
 *     @Qualifier:
 *         作用：在按照类型注入的基础上，再按照名称注入。它在给类成员注入时不能单独使用。
 *             但是在给方法参数注入时可以。
 *     @Resource:
 *         作用：直接按照bean的id注入。它可以独立使用。
 *         属性：
 *            name：用于指定bean的id。
 *     以上三个注解，都只能注入其他bean类型的数据，而基本类型和String类型无法使用。
 *     另外，集合类型的注入，只能通过XML来实现。
 *     @Value
 *         作用：用于注入基本类型和String类型的数据
 *         属性：
 *             value：用于指定数据的值。可以使用SpEL（${表达式}）
 * 3. 用于改变作用范围的
 *     他们的作用就是和在XML配置文件中编写一个<scope>属性实现的功能一样
 *     @Scope
 *         作用：用于指定bean的作用范围
 *         属性：value：指定范围，常用取值：single prototype
 * 4. 和生命周期相关
 *     他们的作用就是和在XML配置文件中编写init-method和destroy-method实现的功能一样
 *     @PostConstruct 用于指定初始化方法
 *     @PreDestroy 用于指定销毁方法
 */
@Component
public class AccountService implements IAccountService {

   /* @Autowired
    @Qualifier(value = "accountDao1")*/
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    public AccountService() {
        System.out.println("对象创建了");
    }

    public void save() {
        accountDao.save();
    }
}
