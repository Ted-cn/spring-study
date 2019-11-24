package com.cui.jdbc;

import java.sql.*;

/**
 * 程序的耦合：程序间的依赖关系
 *     类之间的依赖
 *     方法间的依赖
 * 解耦：降低程序间的依赖关系
 * 解耦的思路：
 *     1. 使用反射来创建对象，而避免使用new关键字；
 *     2. 第二步，通过读取配置文件来获取要创建的对象全限定类名；
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws Exception {
        // 1. 注册数据库驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 2. 获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/spring", "root", "123456");
        // 3. 预处理对象
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM account");
        // 4. 执行SQL
        ResultSet rs = pstm.executeQuery();
        // 5. 处理结果
        while (rs.next()) {
            System.out.println(rs.getString("name") + "\t" + rs.getFloat("money"));
        }
        // 6. 释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
