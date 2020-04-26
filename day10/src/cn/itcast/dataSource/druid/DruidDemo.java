package cn.itcast.dataSource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) {
        // 加载配置文件
        Properties config = new Properties();
        InputStream inStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            config.load(inStream);
            // 获取连接池对象
            DataSource pool = DruidDataSourceFactory.createDataSource(config);

            Connection conn = pool.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
