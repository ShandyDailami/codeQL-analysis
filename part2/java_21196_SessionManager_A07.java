import java.util.HashMap;
import java.util.Map;

public class java_21196_SessionManager_A07 {
    // A simple in-memory store for session data
    private Map<String, String> sessionMap;

    public java_21196_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given sessionId
    public String getUserIdForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}