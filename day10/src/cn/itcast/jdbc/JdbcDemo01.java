package cn.itcast.jdbc;

import java.sql.*;
import java.util.Date;

/**
 * 初识JDBC
 */
public class JdbcDemo01 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            // 导入驱动jar包
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            // 定义SQL语句
            String sql = "update student set age = 20 where sid = 201001";
            String sql2 = "select * from student";
            // 获取执行SQL的对象 Statement
            stmt = conn.createStatement();
            // 执行SQL
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            resultSet = stmt.executeQuery(sql2);
            while (resultSet.next()) {
                int sid = resultSet.getInt(1);      // columnIndex 从1开始
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate(4);
                System.out.println(sid + "\t" + name + "\t" + age + "\t" + birthday);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(resultSet, stmt, conn);

        }

    }
}

/**
 *与JDBC相关的常用对象
 *
 * 1、DriverManager： 驱动管理对象
 *      功能：
 *          1）驱动注册：告知程序该使用哪一个数据库驱动jar
 *          Class.forName("com.mysql.jdbc.Driver");
 *          // 在mysql-5 之后的驱动jar可以省略此注册步骤，因为默认提供了该驱动
 *     F:\Study\CS\java\idea_projects\basic_code\day10\libs\mysql-connector-java-5.1.47-bin.jar!\META-INF\services\java.sql.Driver
 *
 *          查看com.mysql.jdbc.Driver类的源码可知，其中存在静态代码块：
 *          // Register ourselves with the DriverManager
 *         static {
 *             try {
 *                  // 注册给定的驱动程序
 *                 java.sql.DriverManager.registerDriver(new Driver());
 *               } catch (SQLException E) {
 *                 throw new RuntimeException("Can't register driver!");
 *             }
 *         }
 *
 *         2）获取数据库连接
 *         public static Connection getConnection(@NotNull String url,          // jdbc:mysql://ip:port/dbName
 *                                              @Nullable String user,       // 用户名
 *                                              @Nullable String password)   // 密码
 *
 * 2、Connection： 数据库连接对象
 *      1）获取执行SQL的对象
 *          Statement createStatement();
 *          PreparedStatement preparedStatement(String sql);
 *      2) 管理事务
 *          开启事务： void setAutoCommit(boolean autoCommit)
 *          提交事务: void commit();
 *          回滚事务: void rollback();
 *
 * 3、Statement： 用于执行静态 SQL 语句并返回它所生成结果的对象。
 *      1）执行SQL
 *           ResultSet executeQuery(String sql) 执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
 *           int executeUpdate(String sql) 执行给定 SQL 语句，该语句可能为 INSERT、UPDATE 或 DELETE 语句，或者不返回任何内容的 SQL 语句（如 SQL DDL 语句）。
 *
 * 4、ResultSet： 表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
 *      ResultSet 对象具有指向其当前数据行的光标。最初，光标被置于第一行之前。next 方法将光标移动到下一行；
 *      因为该方法在 ResultSet 对象没有下一行时返回 false，所以可以在 while 循环中使用它来迭代结果集。
 *
 *5、PreparedStatement： 表示预编译的 SQL 语句的对象
 *      SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。
 *      使用 Connection 中的 PreparedStatement prepareStatement(String sql)
 *      创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
 */
