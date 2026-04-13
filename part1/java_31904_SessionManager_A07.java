import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class java_31904_SessionManager_A07 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public java_31904_SessionManager_A07() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // In a real world scenario, you would store the username/password in a database
        // and compare them to the provided credentials. For the sake of simplicity,
        // we'll just verify that they match.
        if ("user".equals(username) && "password".equals(password)) {
            session.setAttribute("authenticated", true);
            response.sendRedirect("success.html");
        } else {
            session.setAttribute("authenticated", false);
            response.sendRedirect("failure.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }
}