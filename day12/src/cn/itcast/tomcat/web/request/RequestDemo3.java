package cn.itcast.tomcat.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 如果页面提交的信息中包含有中文，使用POST方式获取时，会出现中文乱码问题
        // 在获取参数前，设置request的编码，以解决中文乱码问题
        request.setCharacterEncoding("utf-8");

        // post 获取请求参数
//        BufferedReader reader = request.getReader();
//        String value = null;
//        while ((value = reader.readLine()) != null) {
//            System.out.println(value);
//        }

        System.out.println("-----------------------------------");

        // 通用方式
//        String username = request.getParameter("username");
//        System.out.println(username);
//
//        String[] hobbies = request.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
//
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            System.out.println(name);
//        }

        Map<String, String[]> map = request.getParameterMap();
        Set<String> names = map.keySet();
        for (String name: names) {
            String[] values = map.get(name);
            System.out.println(name);

            for (String value: values) {
                System.out.println(value);
            }
            System.out.println("------------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();  // 获取所有的请求头名称
            String header = request.getHeader(headerName);  // 通过请求头的名称来获取请求头的值
            System.out.println(headerName + ":  " + header);
        }

        System.out.println("------------------");

        // 通用方式
        String username = request.getParameter("username");
        System.out.println(username);
    }
}
