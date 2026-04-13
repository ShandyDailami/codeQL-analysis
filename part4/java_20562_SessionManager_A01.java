import javax.servlet.http.*;
import java.util.*;

public class java_20562_SessionManager_A01 extends HttpServlet {
    // Use HashMap as storage for sessions
    private Map<String, HttpSession> sessionMap = new HashMap<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        // If session does not exist, create a new one
        HttpSession session = request.getSession();
        if (session.isNew()) {
            // Generate a unique session ID
            String sessionId = UUID.randomUUID().toString();
            session.setId(sessionId);
            sessionMap.put(sessionId, session);
        }

        // Print session ID
        response.setContentType("text/plain");
        response.getWriter().println("Session ID: " + session.getId());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        doGet(request, response);
    }

    public void init() {
        // Not used in this example
    }

    public void destroy() {
        // Not used in this example
    }
}