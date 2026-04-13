import javax.servlet.http.*;
import javax.servlet.*;

public class java_40508_SessionManager_A01 extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a session
        HttpSession session = request.getSession();

        // Set a session attribute
        session.setAttribute("user", "John Doe");

        // Get the session attribute
        String user = (String) session.getAttribute("user");

        // Print out the user
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, " + user + "</h1>");
        out.println("</body></html>");
    }
}