package cn.ituring.design_patterns.p1_iterator;

import java.util.ArrayList;

/**
 * ConcreteAggregate 具体的集合
 * 该角色负责实现Aggregate角色所定义的接口(API), 它会创建出具体的Iterator角色
 */
public class BookShelf implements Aggregate {
    private ArrayList books;

    public BookShelf(int initialSize) {
        this.books = new ArrayList(initialSize);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public Book getBookAt(int index) {
        return (Book) books.get(index);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
