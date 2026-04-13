import java.util.HashMap;
import java.util.Map;

public class java_37579_SessionManager_A03 {
    // A map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_37579_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session
    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return true;
        }
        return false;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}