import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_32173_SessionManager_A07 extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Set session attribute
        session.setAttribute("user", "John Doe");

        // Get session attribute
        String user = (String) session.getAttribute("user");
        PrintWriter out = res.getWriter();

        // Print session attribute
        out.println("<p>Welcome, " + user + "</p>");
    }
}