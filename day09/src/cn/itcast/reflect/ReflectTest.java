package cn.itcast.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用Java反射机制，实现的一个简单的小程序，加载运行配置文件中的类的方法
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 创建一个Properties对象
        Properties config = new Properties();
        // 获取类加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        // 获取class目录下的配置文件
        InputStream configStream = classLoader.getResourceAsStream("config.properties");
        // 加载配置文件
        config.load(configStream);

        String className = config.getProperty("className");
        String methodName = config.getProperty("methodName");

        // 加载该类进内存
        Class cls = Class.forName(className);
        // 创建该类的新实例
        Object obj = cls.getConstructor().newInstance();
        // 获取方法对象
        Method method = cls.getMethod(methodName);
        // 执行方法
        method.invoke(obj);



    }
}
