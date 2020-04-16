package cn.ituring.design_patterns.p1_iterator;

/**
 * ConcreteIterator 具体的迭代器
 * 该角色负责实现Iterator角色定义的接口(API), 包含了遍历集合所必须的信息
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object next() {  // 返回当前元素，并指向下一个元素
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
