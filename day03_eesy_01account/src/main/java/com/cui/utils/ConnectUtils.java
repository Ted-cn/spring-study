package com.cui.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用于从数据源中获取连接并且用于和线程进行绑定
 */
public class ConnectUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection() {
        try {
            // 1. 先从ThreadLocal上获取
            Connection conn = tl.get();
            // 2. 判断当前线程上是否有连接
            if (conn == null) {
                // 3. 从数据源中获取一个连接，并存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 4. 返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        tl.remove();
    }
}
