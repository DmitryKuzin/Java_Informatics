import lib.Author;
import lib.Book;
import lib.Library;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by kuzin on 10/16/2015.
 */
@WebServlet(name = "Servlet" ,urlPatterns="/shop")
public class Servlet extends javax.servlet.http.HttpServlet {
    Library lib;
    @Override
    public void init() throws ServletException {
        lib=new Library();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String authorname=request.getParameter("Author");
        String isbn=request.getParameter("ISBN");
        String name=request.getParameter("Name");
        String price=request.getParameter("Price");
        BigDecimal bd=new BigDecimal(new Integer(price));
        String date=request.getParameter("Creation-date");
        lib.addBook(authorname,new Book(isbn,name,date,bd));
        request.getSession().setAttribute("library",lib);
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("lib",lib);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/shop.jsp");
        dispatcher.include(request,response);
    }
}
