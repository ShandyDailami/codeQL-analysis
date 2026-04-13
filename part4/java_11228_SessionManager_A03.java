import java.util.HashMap;
import java.util.Map;

public class java_11228_SessionManager_A03 {
    // A HashMap to store sessions.
    private Map<String, String> sessionMap;

    public java_11228_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to get the userId for a given sessionId.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}