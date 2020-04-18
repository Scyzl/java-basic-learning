package cn.itcast.day07.doudizhu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 简单版本的斗地主发牌看牌demo
 */
public class DouDiZhu {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();    // 扑克牌集合

        String[] colors = {"♠", "♥", "♣", "♦"};     // 花色
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};

        // 玩家
        ArrayList<String> player0 = new ArrayList<>(17);
        ArrayList<String> player1 = new ArrayList<>(17);
        ArrayList<String> player2 = new ArrayList<>(17);
        ArrayList<String> rest = new ArrayList<>(3);

//        向扑克牌集合中加牌
        poker.add("大王");
        poker.add("小王");

        for (String color : colors) {
            for (String num : numbers) {
                poker.add(color + num);
            }
        }

        // 洗牌
        Collections.shuffle(poker);

//        发牌
        for (int i = 0; i < poker.size(); i++) {
            String p = poker.get(i);

            if (i < 51) {
                switch (i % 3) {
                    case 0: player0.add(p); break;
                    case 1: player1.add(p); break;
                    case 2: player2.add(p); break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i % 3);
                }
            }else
                rest.add(p);
        }

        System.out.println("Scy: " + player0);
        System.out.println("Szl: " + player1);
        System.out.println("Szh: " + player2);
        System.out.println("rest: " + rest);

    }
}
