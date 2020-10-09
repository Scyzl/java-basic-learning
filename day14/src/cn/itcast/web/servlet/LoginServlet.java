package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");      // 设置编码
        // 获取生成的验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");    // 确保验证码一次性，不会重复

        // 获取用户输入的验证码
        String verifycode = request.getParameter("verifycode");

        System.out.println("verifycode: " + verifycode);
        System.out.println("checkcode_server: " + checkcode_server);

        // 校验验证码
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            // 验证码不正确
            // 提示信息
            request.setAttribute("login_msg", "验证码错误！" + verifycode + checkcode_server);
            // 跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            return;
        }
        Map<String, String[]> map = request.getParameterMap();

        // 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service进行查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        if (loginUser != null) {
            // 登录成功
            session.setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            // 登录失败
            request.setAttribute("login_msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
