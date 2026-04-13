import java.util.HashMap;
import java.util.Map;

public class java_08419_SessionManager_A01 {
    private Map<String, String> sessions;
    private static SessionManager sessionManager;

    private java_08419_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for generating a unique session id.
        // You can use any method you prefer.
        return "sessionId";
    }
}