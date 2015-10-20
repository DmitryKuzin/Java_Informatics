import core.ConsoleNoteBook;
import core.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;


@WebServlet(name = "MainServlet",urlPatterns = "/main")
public class MainServlet extends javax.servlet.http.HttpServlet {
    ConsoleNoteBook db;
    List<String> l;
    Note n;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        l= Collections.list(request.getParameterNames());
        n= (Note) request.getAttribute("currentNote");
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        l= Collections.list(request.getSession().getAttributeNames());
//        db= (ConsoleNoteBook) request.getSession().getAttribute("currentDB");
//        request.setAttribute("cN",n);
//        if(l!= null) {
//            request.setAttribute("viewNote",db.getExistNote(l));
//            request.setAttribute("cN",request.getAttribute("currentNote"));
//        }else{
//            request.setAttribute("viewNote",new Note("Vasya","01.01.2001","222-22-22","ya@molodec.com","Moscow,Red Square,Lenin's home"));
//        }
        request.setAttribute("b",request.getAttribute("a"));
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/main.jsp");
        requestDispatcher.include(request,response);
    }
}
