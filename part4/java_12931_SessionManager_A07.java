import java.util.HashMap;
import java.util.UUID;

public class java_12931_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_12931_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a new session
    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}