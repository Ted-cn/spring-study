package com.cui.utils;

import java.sql.SQLException;

/**
 * 将事务管理相关的工具类，它包含了：
 * 开户事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    private ConnectUtils connectUtils;

    public void setConnectUtils(ConnectUtils connectUtils) {
        this.connectUtils = connectUtils;
    }

    /**
     * 开户事务
     */
    public void beginTransaction() {
        try {
            connectUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public void release() {
        try {
            connectUtils.getThreadConnection().close();
            connectUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
