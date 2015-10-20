import core.ConsoleNoteBook;
import core.User;
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
@WebServlet(name = "RegServlet",urlPatterns = "/registration")
public class RegServlet extends HttpServlet {
    UserBase userBase=new UserBase();
    @Override
    public void init() throws ServletException {
        userBase.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setBirth(request.getParameter("birth"));
        user.setCountry(request.getParameter("country"));
        user.setEmail(request.getParameter("email"));
        user.setFIO(request.getParameter("fullName"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        user.setConsoleNoteBook(new ConsoleNoteBook());
        userBase.setUser(user);
        request.getSession().setAttribute("currentUser",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
        requestDispatcher.include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/reg.jsp");
        requestDispatcher.include(request, response);
    }
}
