import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class java_17156_SessionManager_A03 extends HttpServlet {

    // This is a very basic implementation of a SessionManager. 
    // In a real-world situation, this would involve more complex operations.
    // However, since we're only focusing on A03_Injection and security, we'll stick with the basic implementation.

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Create a session object if it doesn't exist
        HttpSession session = request.getSession();

        // Set a value in the session object
        session.setAttribute("user", "User1");

        // Get the value from the session object
        String user = (String) session.getAttribute("user");

        // Print out the user
        PrintWriter out = response.getWriter();
        out.println("User: " + user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Do the same as doGet
        HttpSession session = request.getSession();
        session.setAttribute("user", "User2");

        String user = (String) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        out.println("User: " + user);
   
    }

}