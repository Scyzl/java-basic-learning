package cn.itcast.day02.demo05;

public class ManagerTest {
    public static void main(String[] args) {

        var boss = new Manager("Scy", 200000, 2022, 6, 23);
        boss.setBonus(100000);

        var staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Szl", 200000, 2022, 6, 26);
        staff[2] = new Employee("Zbh", 180000, 2023, 5, 26);

        for (Employee e : staff){
            System.out.println("name=" + e.getName() + ", salary= " + e.getSalary());
        }

        Manager[] managers = new Manager[10];
        managers[0] = boss;

        // ClassCastException: Employee cannot be cast to class Manager
        // managers[1] = (Manager) staff[1];

        Employee[] st = managers;
        st[0] = new Manager("Bob", 5000, 2020, 3, 23);

        for (Employee e : st){
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}
