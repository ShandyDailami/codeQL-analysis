import java.util.HashMap;

public class java_33671_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_33671_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Create session with a unique id
        String sessionId = Long.toString(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Get the username from the session id
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        // Destroy the session
        sessionMap.remove(sessionId);
    }
}