package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getPool());

    @Override
    public List<User> findAll() {
        // 使用JDBC操作数据库
        String sql = "select * from user";
        List<User> users = template.query(sql,
                new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, null, null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义模板初始化SQL
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        // 遍历 Map
        Set<String> keySet = condition.keySet();        // 查询条件的键
        List<Object> params = new ArrayList<>();        // 存储参数
        for (String key : keySet){
            // 排除分页条件参数
            if ("rows".equals(key) || "currentPage".equals(key))
                continue;
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }

        System.out.println(stringBuilder.toString());
        System.out.println(params);

        return template.queryForObject(stringBuilder.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        // 定义模板初始化SQL
        String sql = "select * from user where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        // 遍历 Map
        Set<String> keySet = condition.keySet();        // 查询条件的键
        List<Object> params = new ArrayList<>();        // 存储参数
        for (String key : keySet){
            // 排除分页条件参数
            if ("rows".equals(key) || "currentPage".equals(key))
                continue;
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }

        stringBuilder.append(" limit ?, ?");
        params.add(start);
        params.add(rows);

        System.out.println(stringBuilder.toString());
        System.out.println(params);

        return template.query(stringBuilder.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
