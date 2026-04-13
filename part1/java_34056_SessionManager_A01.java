import java.util.HashMap;
import java.util.Map;

public class java_34056_SessionManager_A01 {
    // A map to hold session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_34056_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    // Method to get session data
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to destroy session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to expunge session
    public void expungeSession(String sessionId) {
        sessionMap.clear();
    }
}