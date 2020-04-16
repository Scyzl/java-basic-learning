package cn.itcast.day03.pair;

import cn.itcast.day03.interfaces.Employee;
import cn.itcast.day03.interfaces.Manager;

public class PairTest {
    public static void main(String[] args) {
        var ceo = new Manager("Scy", 235679, 99999);
        var cfo = new Manager("Szl", 976532, 99998);
        var buddies = new Pair<Manager>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(999999);
        cfo.setBonus(999998);
        Manager[] managers = {ceo, cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                            + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getSecond().getName()
                            + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
        if (a.length == 0)
            return;
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus())
                min = a[i];
            if (max.getBonus() < a[i].getBonus())
                max = a[i];
        }

        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
        minmaxBonus(a, result);
        PairAlg.swap(result);
//        PairAlg.swapHelper(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static <T> void swapHelper(Pair<T> p){
        T first = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(first);
    }

    public static void swap(Pair<?> p){
        swapHelper(p);
    }
}
