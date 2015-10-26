import lib.Author;
import lib.Book;
import lib.Library;
import lib.sqlDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by kuzin on 10/16/2015.
 */
@WebServlet(name = "Servlet" ,urlPatterns="/shop")
public class Servlet extends javax.servlet.http.HttpServlet {
    Library lib=new Library();
    @Override
    public void init() throws ServletException {
        sqlDB sqlDB=new sqlDB();
        lib=sqlDB.getLibrary();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String authorname=request.getParameter("Author");
        String isbn=request.getParameter("ISBN");
        String name=request.getParameter("Name");
        String price=request.getParameter("Price");
        BigDecimal bd=new BigDecimal(new Integer(price));
        String date=request.getParameter("Creation-date");
        lib.addBook(authorname,new Book(isbn,name,date,bd));
        request.getSession().setAttribute("library", lib);
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("lib",lib);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/shop.jsp");
        dispatcher.include(request,response);
    }
}
