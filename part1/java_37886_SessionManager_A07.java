import java.util.HashMap;
import java.util.Map;

public class java_37886_SessionManager_A07 {
    // We use a HashMap as the underlying data structure to store the sessions
    private Map<String, String> sessionMap;

    // SessionManager constructor
    public java_37886_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Simulate a session validation operation by checking if the sessionId exists
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}