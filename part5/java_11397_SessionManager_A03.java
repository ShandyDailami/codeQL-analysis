import java.util.HashMap;
import java.util.Map;

public class java_11397_SessionManager_A03 {

    // Create a Map to store the sessions
    private Map<String, String> sessionMap;

    // Constructor to initialize the sessionMap
    public java_11397_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.put(sessionId, null);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId) && sessionMap.get(sessionId) != null;
    }
}