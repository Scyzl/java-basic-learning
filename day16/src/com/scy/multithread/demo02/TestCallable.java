package com.scy.multithread.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


/**
 * @Author Scy
 * @Date 2020/10/8 16:29
 * @Version 1.0
 */
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println(name + "==>下载完成！");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601026255378&di=32aafb2e27f86e0ac67e9ee8250f199d&imgtype=0&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D115053308%2C1293430074%26fm%3D214%26gp%3D0.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2947066158,2930627509&fm=26&gp=0.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("https://img-blog.csdnimg.cn/20200907085007297.jpg", "3.jpg");

        // 创建执行服务
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> res1 = threadPool.submit(t1);
        Future<Boolean> res2 = threadPool.submit(t2);
        Future<Boolean> res3 = threadPool.submit(t3);

        // 获取结果
        boolean b1 = res1.get();
        boolean b2 = res2.get();
        boolean b3 = res3.get();

        // 关闭服务
        threadPool.shutdownNow();
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
