package cn.itcast.day02.demo02;

/*
overload: 多个方法名称相同，但参数列表不同。
*/

import cn.itcast.day02.demo03.Person;

import java.util.Arrays;
import java.util.Scanner;

public class MethodOverload extends Person {
    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
//        数组的动态初始化（指定长度）
//        数组的静态初始化（指定内容）
        int[] array1 = new int[99];
        int array2[] = new int[90];
        float[] array3 = new float[] {1, 2, 2, 3, 4, 5, 90};
        String[] array4 = new String[] {"hello", "like", "python", "java"};
        System.out.println(array2);
        System.out.println(Arrays.toString(array4));
        float[][] arr = new float[2][3];
//        array1 = {1, 2, 3};

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
        String name = sc.next();

        Person Scy = new Person();
        Scy.setName(name);
        Scy.setAge(num);
        Scy.show();



    }

}
