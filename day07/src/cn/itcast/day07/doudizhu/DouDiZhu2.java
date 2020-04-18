package cn.itcast.day07.doudizhu;

import java.util.*;

/**
 * 有序版本的斗地主小游戏看牌demo，利用Map实现
 */
public class DouDiZhu2 {
    public static void main(String[] args) {
        Map<Integer, String> poker = new HashMap<> ();

        List<Integer> pokerIndex = new ArrayList<>(54);
        List<String> colors = List.of("♠", "♥", "♣", "♦") ;
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        for (String number : numbers) {
            for (String color : colors) {
                index++;
                poker.put(index, color + number);
                pokerIndex.add(index);
            }
        }

//        洗牌
        Collections.shuffle(pokerIndex);
//        System.out.println(pokerIndex);

//        发牌
        List<Integer> player0 = new ArrayList<>();
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();

        for (int j = 0; j < pokerIndex.size(); j++) {
            int i = pokerIndex.get(j);
            if (j < 51) {
                switch (j % 3) {
                    case 0: player0.add(i); break;
                    case 1: player1.add(i); break;
                    case 2: player2.add(i); break;
                }
            }else
                rest.add(i);
        }

//        排序
        Collections.sort(player0);
        Collections.sort(player1);
        Collections.sort(player2);

//        看牌
        showPokers("Scy", player0, poker);
        showPokers("Szl", player1, poker);
        showPokers("Szh", player2, poker);
        showPokers("rest", rest, poker);
    }

    public static void showPokers(String name, List<Integer> list, Map<Integer, String> map) {
        System.out.print(name + ":\t");
        for (Integer i : list) {
            System.out.print(map.get(i) + '\t');
        }
        System.out.println();
    }
}
