import java.util.HashMap;

public class java_15461_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_15461_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Get session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Delete session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if session exists
    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}