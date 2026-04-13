import java.util.HashMap;
import java.util.Map;

public class java_19801_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19801_SessionManager_A07() {
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
        // This is a placeholder for a secure session ID generation method.
        // In a real-world scenario, this method will likely include a combination
        // of user ID, a timestamp, and some other random data.
        // For the sake of this example, we'll just return the user ID.
        return userId;
    }
}