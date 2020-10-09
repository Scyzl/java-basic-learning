package cn.itcast.dao;

import cn.itcast.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库 user表 的类
 */
public class UserDao {

    // 声明JdbcTemplate对象 共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());


    /**
     * 登录方法，连接数据验证登录信息
     * @param loginUser 只有用户名与密码
     * @return 包含User所有信息
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from user where name = ? and password = ?";

            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getName(),
                    loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
