import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class java_13848_SessionManager_A07 {
    private Map<String, HttpSession> sessionMap;

    public java_13848_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(HttpSession session) {
        sessionMap.put(session.getId(), session);
    }

    public HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Add a session
        HttpSession session1 = sessionManager.getSession("session1");
        sessionManager.addSession(session1);

        // Get a session
        HttpSession session2 = sessionManager.getSession("session2");
        System.out.println("Session2: " + (session2 == sessionManager.getSession("session2")));

        // Remove a session
        sessionManager.removeSession("session3");

        // Invalidate all sessions
        sessionManager.invalidateAllSessions();
    }
}