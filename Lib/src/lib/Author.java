package lib;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by kuzin on 9/21/2015.
 */
public class Author extends iKey implements Comparable{
    public Author(String fio){
        FIO=fio;
        keyVariable=fio;
    }
    private String FIO;

    public String getFIO() {
        return FIO;
    }

    private TreeSet<Book> books=new TreeSet<>();
    public void addBook(Book b){
        Book book=b;
        book.setAuthor(this);
        books.add(book);
    }
    public TreeSet<Book> getBooks(){
        return books;
    }
    public void setBooks(TreeSet<Book> creation){
        books=creation;
    }

    @Override
    public String toString() {
        return FIO;
    }
}
