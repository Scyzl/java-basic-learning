package cn.itcast.dataSource.druid;

import cn.itcast.dataSource.utils.JDBCUtils;

import javax.swing.plaf.IconUIResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidUtilsTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();   // 获取连接
            conn.setAutoCommit(false);      // 关闭自动提交，此处没必要，仅是熟悉一下事务

            // 准备 SQL
            String sql = "insert into account values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1005);
            pstmt.setString(2, "Kobe");
            pstmt.setInt(3, 99999);

            // 执行 SQL
            int num = pstmt.executeUpdate();
            System.out.println("此次操作一共影响了" + num + "行数据。");
            conn.commit();      // 提交事务

            JDBCUtils.close(pstmt, conn);   // 释放资源
        } catch (SQLException e) {
            try {
                if (conn != null)
                    conn.rollback();    // 回滚
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
