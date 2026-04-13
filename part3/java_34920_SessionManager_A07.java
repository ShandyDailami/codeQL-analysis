import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class java_34920_SessionManager_A07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check credentials for security
        if (isValid(username, password)) {
            // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to home page
            response.sendRedirect("home.jsp");
        } else {
            // Show an error message
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private boolean isValid(String username, String password) {
        // Add your own logic for security sensitive operations
        // You can use hashed passwords or other methods for security sensitive operations
        // For now, let's just return true to show that it's not empty
        return !username.isEmpty() && !password.isEmpty();
    }
}