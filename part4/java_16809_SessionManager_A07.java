import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_16809_SessionManager_A07 {
    private static final String SESSION_ID_ATTRIBUTE = "sessionId";

    public void createSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getSession().getId();
        response.setHeader(SESSION_ID_ATTRIBUTE, sessionId);
    }

    public void validateSession(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = request.getHeader(SESSION_ID_ATTRIBUTE);
        HttpSession session = request.getSession(false);

        if (session == null || !session.getId().equals(sessionId)) {
            // Session not found or session ID mismatch
            // You can handle this situation according to your application
            // For example, you can send a response to the client, or you can throw an exception
            // Here, I'll just throw an exception
            throw new RuntimeException("Invalid session ID");
        }
    }

    public void invalidateSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}