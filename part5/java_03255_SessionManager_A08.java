import java.util.HashMap;
import java.util.Map;

public class java_03255_SessionManager_A08 {

    // Map to store sessions
    private Map<String, String> sessionMap;

    public java_03255_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String user) {
        // Generate a session id
        String sessionId = UUID.randomUUID().toString();

        // Store session id and user in the session map
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Check if the session id is in the session map
        return sessionMap.containsKey(sessionId);
    }

    // Method to check if a session has expired
    public boolean isSessionExpired(String sessionId) {
        // If the session is valid, check if the session has expired
        if (isValidSession(sessionId)) {
            return isSessionExpired(sessionId);
        }

        return false;
    }
}