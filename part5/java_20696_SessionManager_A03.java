import java.util.HashMap;
import java.util.Map;

public class java_20696_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20696_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String username) {
        String sessionId = Integer.toHexString(username.hashCode());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the username from a session
    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}