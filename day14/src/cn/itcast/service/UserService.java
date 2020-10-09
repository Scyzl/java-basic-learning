package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return List<User>
     */
    public List<User> findAll();

    /**
     * 登录方法
     * @param user 用户输入的用户名和密码封装的对象
     * @return 从数据库中匹配的user
     */
    public User login(User user);

    /**
     * 保存user
     * @param user 新的user
     */
    void addUser(User user);

    /**
     * 根据id删除数据库中的user
     * @param id 要删除的user的id
     */
    void deleteUser(String id);

    /**
     * 根据id查询user
     * @param id 要查询的user的id
     * @return 查询到的user
     */
    User findById(String id);

    /**
     * 更新user
     * @param user 更新后的user
     */
    void updateUser(User user);

    /**
     * 根据页码查询数据，用于实现分页查询
     * @param currentPage   当前页码
     * @param rows      每页显示的记录条数
     * @param condition 查询条件
     * @return  要显示在当前页的数据集合
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
