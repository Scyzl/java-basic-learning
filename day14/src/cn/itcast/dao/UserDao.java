package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的 Dao
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username, String password);

    void add(User user);
    void delete(int id);

    User findById(int parseInt);

    void update(User user);

    /**
     * 查询总记录数
     * @return  总记录数
     * @param condition 查询条件
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页数据
     * @param start 要查询的起始记录
     * @param rows 每页要显示的记录数
     * @param condition 查询条件
     * @return 当前页的数据
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
