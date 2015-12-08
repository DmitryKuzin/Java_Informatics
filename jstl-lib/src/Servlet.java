import lib.Page;
import lib.XmlWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by kuzin on 30.10.2015.
 */
@WebServlet(name = "servlet",urlPatterns = "/main")
public class Servlet extends javax.servlet.http.HttpServlet {
    Page page;
    @Override
    public void init() throws ServletException {
        XmlWorker xmlWorker=new XmlWorker();
        page=xmlWorker.read("C:\\Java_Informatics\\jstl-lib\\conf.txt","/main");

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getSession().setAttribute("page",page);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("index1.jsp");
        requestDispatcher.include(request,response);
    }
}
