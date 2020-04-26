package cn.itcast.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3p0Demo {
    public static void main(String[] args) {
        // 创建数据库连接池对象
        DataSource pool = new ComboPooledDataSource();      // 默认配置
        // DataSource pool = new ComboPooledDataSource("otherc3p0");    // 自定义配置

        try (Connection conn = pool.getConnection()) {
            System.out.println(conn);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
