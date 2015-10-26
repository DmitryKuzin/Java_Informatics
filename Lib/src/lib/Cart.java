package lib;

import javax.servlet.http.Cookie;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by kuzin on 10/22/2015.
 */
public class Cart {
    Enum Currency;
    List<Book> sales;
    public Cart(Enum currency){
        Currency=currency;
        sales=new ArrayList<>();
    }

    public Enum getCurrency() {
        return Currency;
    }
    public void changeCount(String ISBN,int count){
        for(Book b:sales){
            if(b.getISBN().equals(ISBN)){
                sales.remove(b);
                b.setCount(count);
                sales.add(b);
            }
        }
    }
    public void delete(String ISBN){
        sales.removeIf(b->b.getISBN().equals(ISBN));
    }
    public void add(Library library,String ISBN){
        try {
            Book b=foundBook(ISBN);
            if(b!=null){
                sales.remove(b);
                b.countPlus();
                sales.add(b);
            }else {
                Book c = library.getBook(ISBN);
                c.countPlus();
                sales.add(c);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public List<Book> getSales() {
        return sales;
    }
    public BigDecimal getSum(){
        BigDecimal a = new BigDecimal(0);
        for(Book b:sales){
            a=a.add(b.getPrice());
            a=a.multiply(new BigDecimal(b.getCount()));
        }
        return a;
    }
    public Book foundBook(String ISBN){
        for(Book b:sales){
            if(b.getISBN().equals(ISBN)) return b;
        }
        return null;
    }
    public String serializeCart(){
        StringBuilder builder=new StringBuilder();
        for(Book b:sales){
            builder.append(b.getISBN());
            builder.append(",");
            builder.append(b.getCount());
            builder.append(";");
        }
        return builder.toString();
    }
    public void deserializeCart(Cookie cookie,Library library){
        String s=cookie.getValue();
        String[] arr=s.split(";");
        for (String a:arr){
            Book book=library.getBook(a.substring(0, a.indexOf(",")));
            book.setCount(new Integer(a.substring(a.indexOf(",")+1,a.indexOf(";"))));
            sales.add(book);
        }
    }



}
