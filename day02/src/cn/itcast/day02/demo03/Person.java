package cn.itcast.day02.demo03;

public class Person {
    String name;
    private int age;

    public Person() {
    }

    /*
        构造方法： 用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法。
        格式：
            public 类名称（参数类型 参数名称）{
                方法体
            }

        注意事项：
            1、构造方法的名称必须和所在的类名称完全一样。
            2、构造方法不要写返回值类型，包括void。
            3、构造方法不能return返回值。
        */
    public Person(String name, int age){
        this.name = name;
        if (age > 0 && age < 200){
            this.age = age;
        }
        else {
            System.out.println("age数据不合理...");
        }
        System.out.println("构造Person中...");

    }

    public void show(){
        System.out.println("我叫" + name + ", 今年" + age + "岁了。");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        if (age > 0 && age < 200){
            this.age = age;
        }
        else{
            System.out.println("数据不合理...");
        }
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

}
