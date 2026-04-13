import java.util.HashMap;
import java.util.Map;

public class java_29390_SessionManager_A08 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_29390_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to add a new session
    public String addSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        return sessionMap.remove(sessionId);
    }

    // Method to check if a session is present
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}