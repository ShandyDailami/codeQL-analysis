import java.util.HashMap;
import java.util.Map;

public class java_34297_SessionManager_A01 {
    // Using HashMap as in-memory storage for sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_34297_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session by sessionId
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to close the session
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}