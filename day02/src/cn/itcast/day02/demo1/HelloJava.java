package cn.itcast.day02.demo1;

public class HelloJava {
    public static void main(String[] args) {
        printMethod();
        int x = 2, y = 3;
        System.out.println(add(x, y));
    }

    public static void printMethod(){
        System.out.println("hello Java!");
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int add(int a, int b){
        int result = a + b;
        return result;
    }
}

