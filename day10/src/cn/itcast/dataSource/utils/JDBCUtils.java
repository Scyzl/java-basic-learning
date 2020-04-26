package cn.itcast.dataSource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource pool;

    static {
        // 加载配置文件
        Properties config = new Properties();
        try {
            config.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            pool = DruidDataSourceFactory.createDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     * @return 连接池 DataSource pool
     */
    public static DataSource getPool() {
        return pool;
    }

    /**
     * 从数据库连接池中获取一个Connection返回
     * @return Connection
     * @throws SQLException 数据库异常
     */
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    /**
     * 释放资源
     * @param resultSet 需要释放的 ResultSet
     * @param stmt      需要释放的 Statement
     * @param conn      需要释放的 Connection
     */
    public static void close(ResultSet resultSet, Statement stmt, Connection conn) {
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param stmt      需要释放的 Statement
     * @param conn      需要释放的 Connection
     */
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }
}
