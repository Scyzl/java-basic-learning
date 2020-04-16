package cn.ituring.design_patterns.p1_iterator;

import java.util.logging.StreamHandler;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
