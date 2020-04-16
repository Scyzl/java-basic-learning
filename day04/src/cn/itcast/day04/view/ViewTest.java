package cn.itcast.day04.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ViewTest {
    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        System.out.println(strings.getClass());
//         warning only, not an error, for compatibility with legacy code
//         为了与旧代码兼容，只警告，不报错
        ArrayList rawList = strings;
        rawList.add(new Date());    // now strings contains a Date type!
        // 这个add命令在运行时检测不到，只有当另一部分代码调用get方法，并将结果强制转换成String时，
        // 才会出现一个强制转换异常。且只告知强制转换的位置，从报错中无法直接确定问题所在位置。
        String str = (String) rawList.get(0);
        System.out.println(str);

        // 检查型视图可以探测这类问题，定义一个安全列表，这个视图的add方法将检查插入对象是否属于给定的类
//        List<String> safeStrings = Collections.checkedList(strings, String.class);
//        var rawList = safeStrings;
//        rawList.add(new Date());


    }
}
