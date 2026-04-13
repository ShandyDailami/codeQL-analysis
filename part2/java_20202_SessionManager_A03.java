import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

public class java_20202_SessionManager_A03 {
    public void createSession(HttpServletRequest request, HttpServletResponse response) {
        // Create a session object
        HttpSession session = request.getSession();

        // Set an attribute in the session
        session.setAttribute("username", "John Doe");

        // Redirect to a new page
        response.sendRedirect("success.jsp");
    }

    public void manageSession(HttpSession session) {
        // Retrieve the attribute from the session
        String username = (String) session.getAttribute("username");

        // Modify the attribute
        session.setAttribute("username", "Jane Doe");

        // Print the attribute value
        System.out.println("Username: " + username);
    }

    public void destroySession(HttpSession session) {
        // Remove the session
        session.invalidate();
    }
}