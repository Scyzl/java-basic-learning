package cn.itcast.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");

        // 使用字节输入流加载文件进内存
        // 找到文件所在的真实(服务器)路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        // 用字节流关联文件
        InputStream inputStream = new FileInputStream(realPath);

        // 设置response的响应头
        // 设置响应头的类型：context-type
        String mimeType = servletContext.getMimeType(filename);     // 获取文件的mime类型
        resp.setContentType(mimeType);
        // 设置响应头的打开方式
        resp.setHeader("content-disposition", "attachment;filename=" + filename);

        // 将输入流的数据写入到输出流
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
