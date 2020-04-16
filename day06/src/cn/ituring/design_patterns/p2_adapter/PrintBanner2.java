package cn.ituring.design_patterns.p2_adapter;

/**
 * 使用委托的Adapter
 * 在Java语言中，委托就是值将某个方法中的实际处理交给其他实例的方法
 */
public class PrintBanner2 extends Print2 {
    private Banner banner;

    public PrintBanner2(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
