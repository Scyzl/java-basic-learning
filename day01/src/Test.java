public class Test {

    // 静态代码块中的 x 为局部变量，不影响静态变量 x 的值
    static {
        int x = 5;
    }

    static int x, y;    // x 和 y 为static，默认初始值为0，属于当前类的成员变量，其值的改变会影响整个类的运行

    public static void main(String[] args) {
        x--;    // 执行x--后，值为-1
        myMethod();
        System.out.println(x+y+ ++x);       // 1 + 0 + 2
    }

    public static void myMethod() {
        y = x++ + ++x;      // y = -1 + 1
    }
}
