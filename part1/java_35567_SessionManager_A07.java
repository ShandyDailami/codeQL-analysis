import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class java_35567_SessionManager_A07 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if session is active
        if (session.isNew() || session.getAttribute("loggedIn") == null) {
            // Session is not active or not set, so create a new session
            session.setAttribute("loggedIn", true);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Welcome, new user</h1>");
            out.println("</body></html>");
        } else {
            // Session is active, so check if user is logged in
            if ((Boolean) session.getAttribute("loggedIn")) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>Welcome back, user</h1>");
                out.println("</body></html>");
            } else {
                // User is not logged in, so redirect to login page
                response.sendRedirect("login.html");
            }
        }
    }
}