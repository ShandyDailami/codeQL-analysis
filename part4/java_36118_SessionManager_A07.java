import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_36118_SessionManager_A07 {

    public HttpSession getSession(HttpServletRequest request, String sessionId) {
        // Step 1: Validate the sessionId
        if (sessionId != null && !sessionId.isEmpty()) {
            // Step 2: Get the HttpSession object from the request
            HttpSession session = request.getSession(false);

            // Step 3: Check if the session is valid
            if (session != null && session.getId().equals(sessionId)) {
                return session;
            }
        }

        // Step 4: Create a new session if sessionId is null or invalid
        return request.getSession();
    }

    public void invalidateSession(HttpServletRequest request, String sessionId) {
        // Validate the sessionId
        if (sessionId != null && !sessionId.isEmpty()) {
            // Get the HttpSession object from the request
            HttpSession session = request.getSession(false);

            // Check if the session is valid
            if (session != null && session.getId().equals(sessionId)) {
                session.invalidate();
            }
        }
    }

    public void destroySession(HttpServletRequest request, String sessionId) {
        // Validate the sessionId
        if (sessionId != null && !sessionId.isEmpty()) {
            // Get the HttpSession object from the request
            HttpSession session = request.getSession(false);

            // Check if the session is valid
            if (session != null && session.getId().equals(sessionId)) {
                session.destroy();
            }
        }
    }
}