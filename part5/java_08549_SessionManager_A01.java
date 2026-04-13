import java.util.HashMap;
import java.util.Map;

public class java_08549_SessionManager_A01 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    public java_08549_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        String sessionId = "session_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to access a session
    public String getUsername(String sessionId) {
        // We should validate the sessionId and check if it's valid
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // We should validate the sessionId and check if it's valid
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}