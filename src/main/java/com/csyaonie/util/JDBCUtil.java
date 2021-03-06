package com.csyaonie.util;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author zyf
 * @date 2019/7/19
 * @description 获取connection 释放资源
 */
public class JDBCUtil {
    public static Connection getConnection() throws Exception {

        InputStream inputStream=JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");
        String driverClass=properties.getProperty("jdbc.driverClass");
        Class.forName(driverClass);
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void release(ResultSet resultSet, Statement statement,Connection connection){

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
