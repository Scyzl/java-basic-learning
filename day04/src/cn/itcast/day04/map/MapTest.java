package cn.itcast.day04.map;

import cn.itcast.day03.interfaces.Employee;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("2019-34-859", new Employee("Scy", 235679));
        staff.put("2018-23-567", new Employee("Szl", 999999));
        staff.put("dh29892", new Employee("Kobe", 88888));
        staff.put("daiwjiee", new Employee("jdai", 2878));

        System.out.println(staff);
        System.out.println("------------------------------");

        System.out.println(staff.remove("daiwjiee"));
        System.out.println("------------------------------");

        System.out.println(staff.put("dh29892", new Employee("Kobe", 76577687)));
        System.out.println("==============================");
        System.out.println(staff.get("2018-23-567"));
        System.out.println("==============================");

        staff.forEach((k, v) ->
                System.out.println("key = " + k + ", value = " + v));

        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(staff.containsValue(new Employee("Scy", 235679)));
    }
}
