package cn.itcast.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 加载配置文件，连接数据库
     */
    static {
        try {
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resources = classLoader.getResource("jdbc.properties");
            assert resources != null;
            String path = resources.getPath();

            Properties config = new Properties();
            config.load(new FileReader(path));

            url = config.getProperty("url");
            user = config.getProperty("user");
            password = config.getProperty("password");
            driver = config.getProperty("driver");

            Class.forName(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection对象
     * @return 通过配置文件信息创建的Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param resultSet 需要释放的 ResultSet
     * @param stmt      需要释放的 Statement
     * @param conn      需要释放的 Connection
     */
    static void close(ResultSet resultSet, Statement stmt, Connection conn) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
