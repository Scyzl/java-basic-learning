package cn.itcast.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信服务器端：接收客户端的请求，读取客户端发送的内容，给客户端回写数据
 * 表示服务器的类：
 *      java.net.ServerSocket: 此类实现服务器套接字。服务器套接字等待请求通过网络传入。它基于该请求执行某些操作，然后可能向请求者返回结果。
 * 构造器：
 *      ServerSocket(int port)  创建绑定到特定端口的服务器套接字。
 * 成员方法：
 *       Socket accept()    侦听并接受到此套接字的连接。
 *        void close()      关闭此套接字。
 *
 * 实现步骤：
 *      1、创建服务器对象ServerSocket，和系统要指定的端口号
 *      2、使用ServerSocket对象的accept()方法获取请求的客户端Socket对象
 *      3、使用Socket对象的getInputStream()获取网络字节输入流InputStream对象
 *      4、使用InputStream对象的read()方法读取客户端发送的数据
 *      5、使用Socket对象中的getOutputStream()获取网络字节输出流OutputStream对象
 *      6、使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
 *      7、释放资源(ServerSocket, Socket)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
//        1、创建服务器对象ServerSocket，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
//        2、使用ServerSocket对象的accept()方法获取请求的客户端Socket对象
        Socket socket = server.accept();
//        3、使用Socket对象的getInputStream()获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
//        4、使用InputStream对象的read()方法读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
//        5、使用Socket对象中的getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
//        6、使用网络字节输出流OutputStream对象中的方法write，给客户端回写数据
        outputStream.write("你好客户端".getBytes());
//        7、释放资源(ServerSocket, Socket)
        socket.close();
        server.close();
    }
}
