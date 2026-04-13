import java.util.HashMap;
import java.util.Map;

public class java_05324_SessionManager_A08 {

    // Map to hold all sessions.
    private Map<String, String> sessionMap;

    // Constructor to initialize session map.
    public java_05324_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session data.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to update the session data.
    public void updateSession(String sessionId, String newData) {
        sessionMap.put(sessionId, newData);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}