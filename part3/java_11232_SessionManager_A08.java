import java.util.HashMap;
import java.util.Map;

public class java_11232_SessionManager_A08 {
    // Store sessions in a HashMap
    private Map<String, String> sessions;

    public java_11232_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}