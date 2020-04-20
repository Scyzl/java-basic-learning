package cn.itcast.socket.fileupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            OutputStream outputStream = socket.getOutputStream();
            String path = "C:/Users/Scy/Pictures/";
            FileInputStream fis = new FileInputStream(path + "1.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

//          禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
//          如果在套接字上调用 shutdownOutput() 后写入套接字输出流，则该流将抛出 IOException。
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
