package lib;//import lib.Author;
//import lib.Book;
//import lib.iLibrary;

import java.io.Serializable;
import java.util.*;

/**
 * Created by kuzin on 9/21/2015.
 */
public class Library implements iLibrary,Serializable {
    public Library(){}
    public Library(String name){
        setName(name);
    }
    public String getName(){
        return name;
    }

    private TreeMap<Author,TreeSet<Book>> library=new TreeMap<>();
    private String name;

    public TreeMap<Author,TreeSet<Book>> getLibrary(){
        return library;
    }
    @Override
    public void setName(String n) {
        name=n;
    }

    @Override
    public void addAuthor(Author a) {
        library.put(a,a.getBooks());
    }

    public Set<Author> getAuthorsSet(){
        return library.keySet();
    }

    @Override
    public void addBook(String authorName, Book b) {
        Author author=null;
        Set<Author> authorSet=library.keySet();
        Object[] authorArray= library.keySet().toArray();
        for(Object a: authorArray){
            if(a.toString().equals(authorName)){
                author=(Author)a;
            }
        }
        TreeSet<Book> set=null;
        if(author==null){
            set=new TreeSet<>();
            Author a=new Author(authorName);
            b.setAuthor(a);
            set.add(b);
            a.addBook(b);
            library.put(a,set);
        }else {
            set = library.get(author);
            b.setAuthor(author);
            set.add(b);
            author.addBook(b);
            library.replace(author,set);
        }


    }
    @Override
    public List getCreation(Author a) {
        return new ArrayList<>(library.get(a));
    }//gets the list of books of an author

    @Override
    public TreeMap<Author,TreeSet<Book>> getAll() {
        return library;
    }

    @Override
    public boolean removeBook(Author a, String ISBN) {
        TreeSet<Book> books=library.get(a);
        boolean result= books.removeIf(u -> ISBN.equals(u.getISBN()));//lambda -> hello from java 8
        library.put(a,books);
        return result;
    }
}
