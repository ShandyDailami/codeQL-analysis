import java.util.HashMap;
import java.util.Map;

public class java_10998_SessionManager_A03 {
    // Map to store sessions.
    private Map<String, String> sessionMap;

    public java_10998_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new IllegalStateException("Another session is already opened for user " + username);
        }
        String sessionId = username + "_" + System.currentTimeMillis();
        sessionMap.put(username, sessionId);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Method to close a session.
    public void closeSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username == null) {
            throw new IllegalStateException("No session found with ID " + sessionId);
        }
        sessionMap.remove(username);
    }
}