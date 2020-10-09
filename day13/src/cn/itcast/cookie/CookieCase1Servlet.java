package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieCase1Servlet")
public class CookieCase1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息体的数据格式以及编码格式
        response.setContentType("text/html;charset=utf-8");

        // 获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;       // 没有cookie为lastTime

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                // 如果存在lastTime说明不是第一次访问
                if ("lastTime".equals(name)) {

                    flag = true;

                    String value = cookie.getValue();   // 获取cookie的value，上次访问时间

                    System.out.println("解码前: " + value);
                    // URL 解码
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后: " + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间是： " + value + "</h1>");

                    // 响应数据，更新cookie的lastTime的value
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String formatDate = simpleDateFormat.format(date);

                    System.out.println("编码前: " + formatDate);
                    // URL 编码，以消除特殊字符错误
                    formatDate = URLEncoder.encode(formatDate, "utf-8");
                    System.out.println("编码后: " + formatDate);

                    cookie.setValue(formatDate);

                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    break;
                }
            }
        }

        if (cookies == null || cookies.length <= 0 || flag == false) {
            // 第一次访问：创建并响应Cookie
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String formatDate = simpleDateFormat.format(date);

            System.out.println("编码前: " + formatDate);
            formatDate = URLEncoder.encode(formatDate, "utf-8");
            System.out.println("编码后: " + formatDate);

            Cookie cookie = new Cookie("lastTime", formatDate);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎首次访问！</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
