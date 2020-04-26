package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JdbcDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from student";

            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int sid = resultSet.getInt(1);      // columnIndex 从1开始
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate(4);
                System.out.println(sid + "\t" + name + "\t" + age + "\t" + birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtils.close(resultSet, stmt, conn);
    }
}
