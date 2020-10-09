package cn.itcast.tomcat.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求行数据
        String method = request.getMethod();    //  请求方式
        System.out.println("method: " + method);

        String contextPath = request.getContextPath();  // 请求的虚拟目录
        System.out.println("contextPath: " + contextPath);

        String servletPath = request.getServletPath();  // 请求的Servlet路径
        System.out.println("servletPath: " + servletPath);

        String queryString = request.getQueryString();  // 请求参数
        System.out.println("queryString: " + queryString);

        String requestURI = request.getRequestURI();    // 请求的 统一资源标识符
        StringBuffer requestURL = request.getRequestURL();  // 请求的 统一资源定位符
        System.out.println("requestURI: " + requestURI);
        System.out.println("requestURL: " + requestURL);

        String protocol = request.getProtocol();    // 协议及版本
        System.out.println("protocol: " + protocol);

        String remoteAddr = request.getRemoteAddr();    // 客户机的IP地址
        System.out.println("remoteAddr: " + remoteAddr);

        String remoteUser = request.getRemoteUser();    // 请求
        System.out.println(remoteUser);
    }
}
