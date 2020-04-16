package cn.ituring.design_patterns.p2_adapter.homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();

        try {
            f.readFromFile("F:\\Study\\CS\\java\\idea_projects\\basic_code\\day06\\src\\cn\\ituring\\design_patterns\\p2_adapter\\homework\\file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("F:\\Study\\CS\\java\\idea_projects\\basic_code\\day06\\src\\cn\\ituring\\design_patterns\\p2_adapter\\homework\\newFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
