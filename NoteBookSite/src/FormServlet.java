import core.ConsoleNoteBook;
import core.Note;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by kuzin on 10/11/2015.
 */
@WebServlet(name="FormServlet",urlPatterns = "/add")
public class FormServlet extends javax.servlet.http.HttpServlet {
    ConsoleNoteBook noteBook=null;
    @Override
    public void init() throws ServletException {
        noteBook=new ConsoleNoteBook();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        noteBook.add(new Note(request.getParameter("FIO"), request.getParameter("Birth"), request.getParameter("Number"), request.getParameter("Email"), request.getParameter("work")));
        request.getSession().setAttribute("consoleNoteBook",noteBook);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/main.jsp");
        requestDispatcher.include(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/form.jsp");
        requestDispatcher.include(request,response);
    }
}
