import java.util.HashMap;
import java.util.Map;

public class java_38163_SessionManager_A08 {
    private Map<String, String> sessionMap;

    // Initialize session map
    public java_38163_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Initialize a session
    public String initializeSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Validate a session
    public boolean validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Check if the session is expired
            long expirationTime = System.currentTimeMillis() - Long.parseLong(sessionMap.get(sessionId));
            if (expirationTime > Integer.MAX_VALUE) {
                // If the session is expired, remove it
                sessionMap.remove(sessionId);
                return false;
            }
            // If the session is not expired, update it
            sessionMap.put(sessionId, String.valueOf(System.currentTimeMillis()));
            return true;
        } else {
            return false;
        }
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}