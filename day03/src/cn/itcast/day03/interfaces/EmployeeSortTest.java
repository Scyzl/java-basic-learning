package cn.itcast.day03.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];

        staff[0] = new Employee("Scy", 230000);
        staff[1] = new Employee("Szl", 320000);
        staff[2] = new Employee("Szy", 12300);

        Arrays.sort(staff);

        for (Employee e : staff){
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }

    }
}
