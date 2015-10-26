import lib.Book;
import lib.Cart;
import lib.Currency;
import lib.Library;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuzin on 10/16/2015.
 */
@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    Library library=null;
    Cart cart=null;
    @Override
    public void init() throws ServletException {
        cart=new Cart(Currency.rubles);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from=request.getParameter("from");
        if(from.equals("shop")) {
            library = (Library) request.getSession().getAttribute("library");
            String isbn = request.getParameter("ISBN");
            cart.add(library, isbn);
            response.addCookie(new Cookie("cart",cart.serializeCart()));
            request.getSession().setAttribute("cart", cart);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/shop.jsp");
            requestDispatcher.include(request, response);
        }else{
            if(request.getParameter("deleteISBN")==null){
                Integer count =new Integer(request.getParameter("count"));
                String isbn=request.getParameter("countISBN");
                cart.changeCount(isbn,count);
                response.addCookie(new Cookie("cart",cart.serializeCart()));
                request.getSession().setAttribute("cart", cart);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/cart.jsp");
                requestDispatcher.include(request,response);
            }else{
                String isbn=request.getParameter("deleteISBN");
                cart.delete(isbn);
                response.addCookie(new Cookie("cart",cart.serializeCart()));
                request.getSession().setAttribute("cart", cart);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/cart.jsp");
                requestDispatcher.include(request,response);

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ourCookie=null;
//        if(request.getCookies().length!=0) {
//            for (Cookie cookie : request.getCookies()) {
//                if (cookie.getName().equals("cart")) ourCookie = cookie;
//            }
//            cart.deserializeCart(ourCookie, library);
//        }
        request.setAttribute("cart",cart);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/cart.jsp");
        requestDispatcher.include(request,response);
    }
}
