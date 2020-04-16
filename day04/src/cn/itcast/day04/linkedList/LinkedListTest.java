package cn.itcast.day04.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Scy");
        a.add("Szl");
        a.add("love");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Can");
        b.add("Tommy");
        b.add("Bugman");

        // 加载迭代器
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        // 将b插入到a链尾
        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        // 从a中删除b包含的所有元素or对象
        a.removeAll(b);
        System.out.println(a);
    }
}
