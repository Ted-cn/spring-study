package com.cui.service.impl;

import com.cui.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountService3 implements IAccountService {

    private List<String> list;
    private String[] array;
    private Set<String> set;
    private Map<String, Object> map;
    private Properties properties;

    @Override
    public void save() {

    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "AccountService3{" +
                "list=" + list +
                ", array=" + Arrays.toString(array) +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
