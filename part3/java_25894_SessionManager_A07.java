import java.util.HashMap;
import java.util.Map;

public class java_25894_SessionManager_A07 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_25894_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String username) {
        String sessionId = String.valueOf(System.nanoTime());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username associated with a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is still valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}