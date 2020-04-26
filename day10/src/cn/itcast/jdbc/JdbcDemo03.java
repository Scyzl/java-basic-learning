package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*PreparedStatement： 表示预编译的 SQL 语句的对象
*      SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。
*      使用 Connection 中的 PreparedStatement prepareStatement(String sql)
*      创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
*/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        boolean flag = login(userName, password);

        if (flag) {
            System.out.println("登录成功！");
        } else
            System.out.println("登录失败！");
    }

    /**
     * 简单登录
     * @param userName 用户名
     * @param password 密码
     * @return 登录状态
     */
    public static boolean login(String userName, String password) {
        if (userName == null || password == null)
            return false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from msg where name = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet, pstmt, conn);
        }
        return false;
    }
}
