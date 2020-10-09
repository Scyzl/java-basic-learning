package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieServletDemo3")
public class CookieServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "setAge");
        cookie.setMaxAge(30);   // 设置cookie的存活时间，即将cookie持久化到硬盘，30s后删除
//        cookie.setMaxAge(-1);   // 负数为默认值，cookie只保存在浏览器内存中，不被持久化到硬盘
//        cookie.setMaxAge(0);  // 删除cookie信息
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
