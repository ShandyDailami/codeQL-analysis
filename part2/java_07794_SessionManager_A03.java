import java.util.HashMap;
import java.util.Map;

public class java_07794_SessionManager_A03 {
    // Data structure to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_07794_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get a session by session id
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session by session id
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}