package cn.ituring.design_patterns.p1_iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(3);
        bookShelf.appendBook(new Book("Around World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-legs"));
        bookShelf.appendBook(new Book("Hamlet"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
