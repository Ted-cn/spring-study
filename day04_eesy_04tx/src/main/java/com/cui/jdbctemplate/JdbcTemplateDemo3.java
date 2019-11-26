package com.cui.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的CRUD
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 准备数据源
        DriverManagerDataSource ds;
        // 创建JdbcTemplate对象
        JdbcTemplate jt = ac.getBean("jt", JdbcTemplate.class);
        // 执行操作
    }
}
