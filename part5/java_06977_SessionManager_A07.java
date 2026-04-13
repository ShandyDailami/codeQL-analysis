import java.util.HashMap;
import java.util.Map;

public class java_06977_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_06977_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId(String userId) {
        // Simple hashing function for demo purposes
        int hash = 7;
        hash = 31 * hash + userId.hashCode();
        return Integer.toString(hash);
    }
}