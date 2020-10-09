package com.scy.multithread.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @Author Scy
 * @Date 2020/10/8 9:06
 * @Version 1.0
 */
public class TestThread2 extends Thread{

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println(name + "下载完成！");
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601026255378&di=32aafb2e27f86e0ac67e9ee8250f199d&imgtype=0&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D115053308%2C1293430074%26fm%3D214%26gp%3D0.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2947066158,2930627509&fm=26&gp=0.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://img-blog.csdnimg.cn/20200907085007297.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 下载器
 */
class WebDownloader {

    /**
     * 下载方法
     * @param url 文件的url地址
     * @param name 下载到哪里
     */
    public void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download()方法出现问题！");
        }
    }
}
