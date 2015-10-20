package lib;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by kuzin on 9/21/2015.
 */
public interface iLibrary {
    void setName(String n);
    void addAuthor(Author a);
    void addBook(String authorName, Book b);
    List getCreation(Author a);
    TreeMap<Author,TreeSet<Book>> getAll();
    boolean removeBook(Author a, String ISBN);
}
