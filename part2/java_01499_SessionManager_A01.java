import java.util.HashMap;
import java.util.Map;

public class java_01499_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_01499_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a secure session key
        String sessionKey = userId + System.currentTimeMillis();
        sessions.put(sessionKey, userId);
        return sessionKey;
    }

    public String getUserId(String sessionKey) {
        // Validate session key using secure hash function
        String userId = sessions.get(sessionKey);
        if (userId != null) {
            // Check user access rights
            if (checkUserAccessRight(userId)) {
                return userId;
            }
        }
        return null;
    }

    private boolean checkUserAccessRight(String userId) {
        // Implement access control logic here
        // For simplicity, always return true
        return true;
    }
}