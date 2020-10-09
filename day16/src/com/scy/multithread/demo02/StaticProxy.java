package com.scy.multithread.demo02;

/**
 * 静态代理模式
 * @Author Scy
 * @Date 2020/10/8 19:50
 * @Version 1.0
 */
public class StaticProxy {

    public static void main(String[] args) {
        Person person = new Person("scy");
        WeddingCompany company = new WeddingCompany(person);
        company.wedding();
    }
}

interface Marry {

    void happyMarry();
}

class Person implements Marry {

    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public void happyMarry() {
        System.out.println(name + "今天结婚了，超开心的~");
    }

    public String getName() {
        return name;
    }
}

class WeddingCompany {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    public void wedding() {
        before();
        target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("婚礼后，收取尾款");
    }

    private void before() {
        System.out.println("婚礼前：布置现场");
    }
}