import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/SessionExample")
public class java_10057_SessionManager_A07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Get the session
        HttpSession session = request.getSession();

        // Create a session attribute
        session.setAttribute("message", "Hello, session!");

        // Retrieve and print the session attribute
        String message = (String) session.getAttribute("message");
        response.getWriter().println("Session attribute message: " + message);
    }
}