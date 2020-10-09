package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制类型转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 获取资源请求路径
        String uri = request.getRequestURI();
        // 判断是否包含登录相关资源, 要注意排除 css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") ||uri.contains("/js/") || uri.contains("/checkCodeServlet") || uri.contains("/fonts/")) {
            // 包含，用户想登录，放行
            chain.doFilter(request, resp);
        }else {// 不包含，验证用户是否已经登录
            // 从Session获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                // 用户已登录，放行
                chain.doFilter(request, resp);
            }else {
                // 没有登录，跳转到登录页面
                request.setAttribute("login_msg", "您尚未登录，请登录！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
