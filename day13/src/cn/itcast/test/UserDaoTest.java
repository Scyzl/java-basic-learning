package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void loginTest() {

        User loginUser = new User();

        loginUser.setId(20200001);
        loginUser.setName("uzi");
        loginUser.setPassword("999999");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        System.out.println(user);


    }
}
