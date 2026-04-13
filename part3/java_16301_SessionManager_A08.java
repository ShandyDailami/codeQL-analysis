import java.util.HashMap;
import java.util.Map;

public class java_16301_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16301_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session integrity failure: Session with ID " + sessionId + " does not exist!");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("session1");

        // Check session integrity
        sessionManager.checkSessionIntegrity(sessionId);

        // Destroy the session
        sessionManager.destroySession(sessionId);

        // Check session integrity (should fail)
        try {
            sessionManager.checkSessionIntegrity(sessionId);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}