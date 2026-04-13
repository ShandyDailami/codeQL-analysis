import java.util.HashMap;
import java.util.Map;

public class java_33315_SessionManager_A07 {
    // Using a HashMap as the session storage
    private Map<String, String> sessions;

    public java_33315_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId from a session
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to validate if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}