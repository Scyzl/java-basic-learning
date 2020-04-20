package cn.itcast.socket.bsServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        /**
         * 浏览器解析服务器回写的HTML页面，页面中如果有图片，浏览器就会单独开启一个线程，读取服务器的图片。
         */
        while (true) {
             Socket socket = server.accept();

             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     try {
                         InputStream ins = socket.getInputStream();
                         // 把网络字节流输入对象InputStream,转换成字节缓冲输入流BufferedReader
                         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));

                         // 读取客户端请求信息的第一行
                         String line = bufferedReader.readLine();
//                         System.out.println(line);

                         // 获得要访问文件的地址
                         String[] str = line.split(" ");        //  切割
                         String htmlPath = str[1].substring(1);       // 去除'/'

                         FileInputStream fis = new FileInputStream(new File(htmlPath));
                         OutputStream outputStream = socket.getOutputStream();
                         // 写入HTTP协议响应头，固定写法
                         outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                         outputStream.write("Content-type: text/html\r\n".getBytes());
                         outputStream.write("\r\n".getBytes());

                         // 一读一写复制文件，把客户端要访问的页面，从服务器读取出来并返回给客户端
                         int len = 0;
                         byte[] bytes = new byte[1024];
                         while ((len = fis.read(bytes)) != -1) {
                             outputStream.write(bytes, 0, len);
                         }
                         socket.close();

                     }catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }).start();
         }
    }
}
