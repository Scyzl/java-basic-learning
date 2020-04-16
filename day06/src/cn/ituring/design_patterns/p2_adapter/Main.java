package cn.ituring.design_patterns.p2_adapter;

public class Main {
    public static void main(String[] args) {
//        Print p = new PrintBanner("Hello");       // 使用继承的Adapter
        Print2 p = new PrintBanner2("Hello");   // 使用委托的Adapter
        p.printWeak();
        p.printStrong();
    }
}

/**
 * Adapter模式中的登场角色
 *
 * Target (对象)  --Print接口 和 Print类
 *      该角色负责定义所需的方法。
 *
 * Client (请求者)     --Main
 *      该角色使用Target角色所定义的方法进行具体的处理
 *
 * Adaptee (被适配者)   --Banner
 *      一个持有既定方法的角色
 *
 * Adapter (适配器)     --PrintBanner
 *      使用Adaptee角色的方法来满足Target角色的需求
 */

/**
 * Adapter 模式 会对现有的类进行适配，生成新的类。通过该模式可以很方便的创建我们需要的方法群。
 * 当出现Bug时，由于我们很明确的知道Bug不在现有的类（Adaptee角色）中，所以只需要调查扮演Adapter角色的类即可。
 */
