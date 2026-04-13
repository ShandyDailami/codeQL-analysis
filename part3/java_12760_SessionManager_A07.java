import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_12760_SessionManager_A07 {
    public void startSession(HttpServletRequest request, HttpServletResponse response) {
        // Create a new session and store it in the request object
        HttpSession session = request.getSession();
        session.setAttribute("user", "User");
    }

    public void endSession(HttpServletRequest request, HttpServletResponse response) {
        // Get the session from the request object
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Destroy the session
            session.invalidate();
        }
    }

    public void manageAccess(HttpServletRequest request, HttpServletResponse response) {
        // Check if the session is active
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Check if the user is authenticated
            if ("User".equals(session.getAttribute("user"))) {
                // If the user is authenticated, allow access
                System.out.println("Access granted!");
            } else {
                // If the user is not authenticated, deny access
                System.out.println("Access denied!");
                // Start a new session
                startSession(request, response);
            }
        } else {
            // If the session is not active, start a new session
            startSession(request, response);
        }
    }
}