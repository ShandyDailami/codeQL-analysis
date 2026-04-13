import java.util.HashMap;

public class java_36536_SessionManager_A03 {
    // Store sessions
    private HashMap<String, String> sessionMap;

    // Initialize session map
    public java_36536_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Get a session by its id
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Close a session by its id
    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}