import java.util.HashMap;
import java.util.Map;

public class java_33728_SessionManager_A03 {

    private Map<String, String> sessionMap;
    private static SessionManager sessionManager;

    // Private Constructor for Singleton Pattern
    private java_33728_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Static Method to get the SessionManager instance
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Method to add session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get userId from session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}