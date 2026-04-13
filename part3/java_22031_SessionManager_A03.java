import java.util.HashMap;
import java.util.Map;

public class java_22031_SessionManager_A03 {
    private Map<String, String> sessionMap;

    // A Session Manager should not be able to create new sessions
    // This constructor is private to enforce the singleton pattern
    private java_22031_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Singleton design pattern
    private static SessionManager sessionManager;

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}