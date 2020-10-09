package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");      // 设置编码
/*

        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 封装User对象
        User loginUser = new User();
        loginUser.setName(username);
        loginUser.setPassword(password);
*/
        // 获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        // 创建User对象
        User loginUser = new User();
        // 使用BeanUtils 自动进行封装。注意：传递的参数与定义的JavaBean对象的成员变量名称要一致！
        try {
            // 将map集合键值对信息，自动解析封装到对应的JavaBean对象中
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(loginUser);

        // 调用UserDao的login方法，验证登录
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        // 判断登录是否成功
        if (user == null) {
            // 登录失败，请求转发到 /failServlet
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        }else {
            // 登录成功，存储数据到 request域，以便共享
            req.setAttribute("user", user);
            // 转发到 /successServlet
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
