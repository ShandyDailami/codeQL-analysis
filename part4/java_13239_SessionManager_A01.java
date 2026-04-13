import java.util.HashMap;

public class java_13239_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_13239_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // Add a new session
        String sessionId = "session" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Get the username associated with a session
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        // Remove a session from the session map
        sessionMap.remove(sessionId);
    }
}