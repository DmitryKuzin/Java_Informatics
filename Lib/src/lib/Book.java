package lib;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kuzin on 9/21/2015.
 */
public class Book implements Comparable<Book>,Serializable{
    public Book(){}
    public Book(String isbn,String name,String date_ddMMyyyy,BigDecimal price){
        setISBN(isbn);
        setName(name);
        setDate(date_ddMMyyyy);
        setPrice(price);
    }
    public Book(String isbn, Author a,String name,String date_ddMMyyyy,BigDecimal price){
       setISBN(isbn);
        setAuthor(a,true);
        setName(name);
        setDate(date_ddMMyyyy);
        setPrice(price);
    }
    private String ISBN;
    private Author author;
    private String name;
    private String date;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String isbn){
        ISBN=isbn;
    }
    public Author getAuthor(){
        return author;
    }
    public void setAuthor(Author a){
        author = a;
    }
    public void setAuthor(Author a,boolean sayAuthorAboutBook){
        if(sayAuthorAboutBook) {
            a.addBook(this);
        }
        author = a;
    }
    public String getName(){
        return name;
    }
    public void setName(String bookName){
        name=bookName;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String ddMMyyyy) {
        date=ddMMyyyy;
    }
    @Override
    public int compareTo(Book o) {
        return getDate().compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode()==hashCode();
    }

    @Override
    public int hashCode() {
        return new Integer(ISBN);
    }
}
