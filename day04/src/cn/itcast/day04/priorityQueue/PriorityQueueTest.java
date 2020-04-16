package cn.itcast.day04.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(2013, 10, 13));
        pq.add(LocalDate.of(2018, 1, 17));
        pq.add(LocalDate.of(2019, 7, 4));
        pq.add(LocalDate.of(1996, 5, 26));

        System.out.println("Iterating over elements ... ");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
//        System.out.println(pq);
        System.out.println("Removing elements ... ");
        while (! pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
