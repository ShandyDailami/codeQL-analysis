import java.util.HashMap;
import java.util.Map;

public class java_39070_SessionManager_A01 {
    // A map to store session data.
    private Map<String, Object> sessionData;

    // Constructor
    public java_39070_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionData.put(sessionId, new Object());
        return sessionId;
    }

    // Method to get a session data
    public Object getSessionData(String sessionId) {
        if (!sessionData.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
        return sessionData.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        if (!sessionData.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
        sessionData.remove(sessionId);
    }
}