package com.cui.service.impl;

import com.cui.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountService2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountService2() {
        System.out.println("对象创建了");
    }

    @Override
    public void save() {
        System.out.println("保存了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
