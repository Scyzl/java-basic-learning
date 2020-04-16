package cn.itcast.day03.interfaces;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void raisedSalary(double byPercent) {
        double raised = salary * byPercent /100;
        salary += raised;
    }

    @Override
    public int compareTo(Employee o) {
//        return Double.compare(salary, o.salary); // 按照salary进行sort
        return name.compareTo(o.name);              // 按照name（字典序）进行sort
    }
}
