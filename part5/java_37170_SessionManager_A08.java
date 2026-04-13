import java.util.HashMap;
import java.util.Map;

public class java_37170_SessionManager_A08 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    public java_37170_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to check if a session exists
    public boolean checkSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to access a session
    public String accessSession(String sessionId) {
        if (!checkSession(sessionId)) {
            // This session does not exist, return an integrity failure message
            return "IntegrityFailure";
        }

        // This session does exist, return the sessionId
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}