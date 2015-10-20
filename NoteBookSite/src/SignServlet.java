import core.Sign;
import core.UserBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kuzin on 10/18/2015.
 */
@WebServlet(name = "SignServlet",urlPatterns = "/sign")
public class SignServlet extends HttpServlet {
    UserBase userBase;
    boolean checked;
    protected String email,pass;
    @Override
    public void init() throws ServletException {
        userBase=new UserBase();
        userBase.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email=request.getParameter("email");
        pass=request.getParameter("password");
        checked=userBase.check(email,pass);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(checked) {
            request.getSession().setAttribute("currentUser",userBase.getUser(email,pass));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
            requestDispatcher.forward(request, response);
        }else{
            request.setAttribute("checked",false);//???????? ????????? ?? index.jsp
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);
        }
    }
}
