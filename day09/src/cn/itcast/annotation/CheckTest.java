package cn.itcast.annotation;

import cn.itcast.demo.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 简单的测试框架
 *
 * 当主程序执行后，会自动执行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，有则记录到文件中
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        Calculator cal = new Calculator();

        int num = 0;        // 记录异常出现的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("Bug.txt"));

        // 获取字节码文件对象
        Class cls = cal.getClass();
        // 获取该类包含的所有方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(cal);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName() + "出现异常！");
                    bw.newLine();
                    bw.write("异常类型： " + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因： " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("----------------------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次执行共出现" + num + "次异常！");

        bw.flush();     //  刷新该流的缓冲
        bw.close();
    }
}

