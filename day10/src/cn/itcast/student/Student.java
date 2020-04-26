package cn.itcast.student;

import java.util.Date;

public class Student {
    private int sid;
    private String name;
    private int age;
    private Date birthday;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid = " + sid +
                ", name = " + name +
                ", age = " + age +
                ", birthday = " + birthday + "}";
    }
}
