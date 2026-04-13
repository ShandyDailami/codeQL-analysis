import java.util.HashMap;
import java.util.Map;

public class java_17637_SessionManager_A01 {
    // a map to store sessions
    private Map<String, String> sessionMap;

    // constructor
    public java_17637_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // method to create a session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // method to get the username from a session
    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // session not found
        }
    }

    // method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}