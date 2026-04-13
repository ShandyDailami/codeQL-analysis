import java.util.HashMap;
import java.util.Map;

public class java_20240_SessionManager_A01 {
    private Map<String, String> sessionMap;

    // Constructor
    public java_20240_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for starting a new session
    public String startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method for checking the validity of a session
    public String checkSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, "Invalid Session");
    }

    // Method for ending a session
    public String endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            return "Ended session for user: " + userName;
        } else {
            return "Invalid Session";
        }
    }

    // Method for generating session ID
    private String generateSessionId() {
        // This is a placeholder implementation. It generates a random session ID.
        // Normally, it should use a cryptographic hash function.
        return String.valueOf(System.currentTimeMillis());
    }
}