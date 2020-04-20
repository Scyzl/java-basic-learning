package cn.itcast.socket.fileupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket socket = server.accept();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String filename;
                        try (InputStream inputStream = socket.getInputStream()) {

                            File path = new File("F:/upload/");
                            if (!path.exists())
                                path.mkdirs();
                            filename = "/it" + System.currentTimeMillis() + ".jpg";
                            FileOutputStream fop = new FileOutputStream(path + filename);
                            byte[] bytes = new byte[1024];
                            int len = 0;
                            while ((len = inputStream.read(bytes)) != -1) {
                                fop.write(bytes, 0, len);
                            }
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write((filename + "上传成功").getBytes());

                            socket.close();
                        }catch (IOException | NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();
            }
    }
}
