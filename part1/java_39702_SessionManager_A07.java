import java.util.HashMap;
import java.util.Map;

public class java_39702_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39702_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a session key using userId
        String sessionKey = userId + System.currentTimeMillis();
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    public String getUserId(String sessionKey) {
        // Validate the session key and get the userId
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            throw new SecurityException("Invalid session key");
        }
    }

    public void deleteSession(String sessionKey) {
        // Delete the session from the map
        sessionMap.remove(sessionKey);
    }
}